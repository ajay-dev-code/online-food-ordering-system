package com.example.OnlineFoodOrderingSystem.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "foodItem")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FoodItem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private Long foodItemId;
	private String category;
	@NotBlank(message = "Name cannot be blank")
	private String name;
	private String description;
	private Boolean avaible = true;
	private Double price = 0.0;

	@ManyToOne
	@JoinColumn(name = "restaurant_id", nullable = false)

	private Restaurant restaurant;

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean getAvaible() {
		return avaible;
	}

	public void setAvaible(Boolean avaible) {
		this.avaible = avaible;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	public Long getFoodItemId() {
		return foodItemId;
	}

}
