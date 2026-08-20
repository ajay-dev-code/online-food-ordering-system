package com.example.OnlineFoodOrderingSystem.Entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "restaurant")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Restaurant {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private Long id;
	@NotBlank(message = "Name cannot blank")
	private String name;
	@NotBlank(message = "location is required")
	private String location;
	@Pattern(regexp = "^[0-9]{10}$", message = "phone must be 10 digits")
	private String phone;
	private String description;
	private Boolean open = true;
	private Double rating = 0.0;
	@OneToMany(mappedBy = "restaurant")
	@JsonIgnore
	private List<FoodItem> foodItems;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean getIsopen() {
		return open;
	}

	public void setIsopen(Boolean open) {
		this.open = open;
	}

	public Double getRating() {
		return rating;
	}

	public void setRating(Double rating) {
		this.rating = rating;
	}

	public Long getId() {
		return id;
	}

}
