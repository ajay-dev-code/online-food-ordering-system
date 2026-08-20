package com.example.OnlineFoodOrderingSystem.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.OnlineFoodOrderingSystem.Entity.Restaurant;
import com.example.OnlineFoodOrderingSystem.Service.RestaurantService;

@RestController
@RequestMapping("/restaurant")
public class RestaurantController {

	private final RestaurantService restservice;

	public RestaurantController(RestaurantService restservice) {
		this.restservice = restservice;
	}

	@PostMapping
	public ResponseEntity<Restaurant> createUser(@RequestBody Restaurant restaurant) {
		Restaurant created = restservice.createRestaurant(restaurant);
		return new ResponseEntity<Restaurant>(created, HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<List<Restaurant>> getAllRestaurant() {
		List<Restaurant> getAllrestaurant = restservice.getAllRestaurants();
		return ResponseEntity.ok(getAllrestaurant);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Restaurant> getAllId(@PathVariable Long id) {
		Restaurant restaurantId = restservice.getRestaurantById(id);
		return ResponseEntity.ok(restaurantId);

	}

	@PutMapping("/{id}")
	public ResponseEntity<Restaurant> update(@PathVariable Long id, @RequestBody Restaurant restaurant) {
		Restaurant updated = restservice.updateRestaurant(id, restaurant);
		return ResponseEntity.ok(updated);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteById(@PathVariable Long id) {
		restservice.deleteRestaurant(id);
		return ResponseEntity.ok("Restaurant deleted successfully");
	}

	@GetMapping("/location")
	public ResponseEntity<List<Restaurant>> getByLocation(@RequestParam String location) {
		List<Restaurant> restaurants = restservice.getByLocation(location);
		return ResponseEntity.ok(restaurants);
	}

	@GetMapping("/open")
	public ResponseEntity<List<Restaurant>> getOpenRestaurant() {
		List<Restaurant> restaurants = restservice.getOpenRestaurants();
		return ResponseEntity.ok(restaurants);
	}

	@GetMapping("/rating")
	public ResponseEntity<List<Restaurant>> getTopRated(@RequestParam double rating) {
		List<Restaurant> restaurants = restservice.getTopRated(rating);
		return ResponseEntity.ok(restaurants);
	}

}
