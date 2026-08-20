package com.example.OnlineFoodOrderingSystem.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.OnlineFoodOrderingSystem.Entity.Cart;
import com.example.OnlineFoodOrderingSystem.Entity.FoodItem;
import com.example.OnlineFoodOrderingSystem.Entity.User;
import com.example.OnlineFoodOrderingSystem.Repository.CartRepository;
import com.example.OnlineFoodOrderingSystem.Repository.FoodItemRepository;
import com.example.OnlineFoodOrderingSystem.Repository.UserRepository;

@Service
public class CartService {
	@Autowired
	private CartRepository cartrepo;
	@Autowired
	private UserRepository userrepo;
	@Autowired
	private FoodItemRepository foodrepo;

	public Cart addToCart (Long id, Long foodItemId, int quantity) {

		User user = userrepo.findById(id).orElseThrow(() -> new RuntimeException("User not found " + id));

		FoodItem fooditem = foodrepo.findById(foodItemId)
				.orElseThrow(() -> new RuntimeException("Food item not found" + foodItemId));

		Cart cart = new Cart();
		cart.setUser(user);
		cart.setFooditem(fooditem);
		cart.setQuantity(quantity);
		cart.setTotalPrice(fooditem.getPrice() * quantity);

		return cartrepo.save(cart);
	}

	public List<Cart> getByUserId(Long id) {
		return cartrepo.findByUserId(id);
	}

	public Cart updateQuantity(Long id, int quantity) {
		Cart cart = cartrepo.findById(id).orElseThrow(() -> new RuntimeException("Cart  not found " + id));

		cart.setQuantity(quantity);
		cart.setTotalPrice(cart.getFooditem().getPrice() * quantity);

		return cartrepo.save(cart);
	}

	public void removeItem(Long cartId) {
		cartrepo.deleteById(cartId);
	}

	public void clearCart(Long id) {
		cartrepo.deleteByUserId(id);
	}

}
