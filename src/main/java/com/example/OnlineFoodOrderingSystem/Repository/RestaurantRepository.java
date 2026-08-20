package com.example.OnlineFoodOrderingSystem.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.OnlineFoodOrderingSystem.Entity.Restaurant;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Long>{


    List<Restaurant> findByLocation(String location);

    List<Restaurant> findByRatingGreaterThanEqual(Double rating);
    

    List<Restaurant> findByOpenTrue();
}
