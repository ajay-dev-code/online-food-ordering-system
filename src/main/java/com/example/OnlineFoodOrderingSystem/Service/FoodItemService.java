package com.example.OnlineFoodOrderingSystem.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.OnlineFoodOrderingSystem.Entity.FoodItem;
import com.example.OnlineFoodOrderingSystem.Repository.FoodItemRepository;

@Service
public class FoodItemService {

	@Autowired
	private FoodItemRepository foodrepo;

	public FoodItem saveFoodItem(FoodItem foodItem) {
		return foodrepo.save(foodItem);
	}

	public List<FoodItem> findByCategory(String category) {
		return foodrepo.findByCategory(category);
	}

	public List<FoodItem> findByPriceLessThan(Double price) {
		return foodrepo.findByPriceLessThan(price);
	}

	public List<FoodItem> serachByName(String name) {
		return foodrepo.searchByName(name);
	}
}
