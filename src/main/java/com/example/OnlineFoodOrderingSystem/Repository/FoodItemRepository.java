package com.example.OnlineFoodOrderingSystem.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.OnlineFoodOrderingSystem.Entity.FoodItem;

@Repository
public interface FoodItemRepository extends JpaRepository<FoodItem, Long>{

	List<FoodItem> findByCategory(String category);

	List<FoodItem> findByPriceLessThan(Double price);

	List<FoodItem> searchByName(String name);
}