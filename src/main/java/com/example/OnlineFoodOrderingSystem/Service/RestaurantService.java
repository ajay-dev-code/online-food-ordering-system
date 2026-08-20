package com.example.OnlineFoodOrderingSystem.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.OnlineFoodOrderingSystem.Entity.Restaurant;
import com.example.OnlineFoodOrderingSystem.Repository.RestaurantRepository;

@Service
public class RestaurantService {
	@Autowired
	private RestaurantRepository restaurantRepository;

	public Restaurant createRestaurant(Restaurant restaurant) {
		return restaurantRepository.save(restaurant);
	}

	public List<Restaurant> getAllRestaurants() {
		return restaurantRepository.findAll();
	}

	public Restaurant getRestaurantById(Long id) {
		return restaurantRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Restaurant not found with id " + id));
	}

	public Restaurant updateRestaurant(Long id, Restaurant restaurant) {

		Restaurant existing = getRestaurantById(id);

		existing.setName(restaurant.getName());
		existing.setLocation(restaurant.getLocation());
		existing.setPhone(restaurant.getPhone());
		existing.setDescription(restaurant.getDescription());
		existing.setIsopen(restaurant.getIsopen());
		existing.setRating(restaurant.getRating());

		return restaurantRepository.save(existing);
	}

	public void deleteRestaurant(Long id) {
		restaurantRepository.deleteById(id);
	}

	public List<Restaurant> getByLocation(String location) {
		return restaurantRepository.findByLocation(location);
	}

	public List<Restaurant> getOpenRestaurants() {
		return restaurantRepository.findByOpenTrue();
	}

	public List<Restaurant> getTopRated(Double rating) {
		return restaurantRepository.findByRatingGreaterThanEqual(rating);
	}
}
