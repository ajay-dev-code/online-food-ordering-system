package com.example.OnlineFoodOrderingSystem.Controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.OnlineFoodOrderingSystem.Entity.FoodItem;
import com.example.OnlineFoodOrderingSystem.Service.FoodItemService;

@RestController
@RequestMapping("/fooditems")
public class FoodItemController {

	private final FoodItemService foodservice;

	public FoodItemController(FoodItemService foodservice) {
		this.foodservice = foodservice;
	}

	@PostMapping
	public ResponseEntity<FoodItem> createFoodItem(@RequestBody FoodItem foodItem) {

		FoodItem savedFoodItem = foodservice.saveFoodItem(foodItem);

		return ResponseEntity.status(201).body(savedFoodItem);
	}

	@GetMapping("/category")
	public ResponseEntity<List<FoodItem>> getFoodItemByCategory(@RequestParam String category) {
		List<FoodItem> fooditem = foodservice.findByCategory(category);
		return ResponseEntity.ok(fooditem);
	}

	@GetMapping("/price")
	public ResponseEntity<List<FoodItem>> getPriceLessThan(@RequestParam double price) {
		List<FoodItem> fooditem = foodservice.findByPriceLessThan(price);
		return ResponseEntity.ok(fooditem);
	}

	@GetMapping("/name")
	public ResponseEntity<List<FoodItem>> getOrderById(@RequestParam String name) {
		List<FoodItem> fooditem = foodservice.serachByName(name);
		return ResponseEntity.ok(fooditem);
	}
}
