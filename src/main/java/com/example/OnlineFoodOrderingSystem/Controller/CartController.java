package com.example.OnlineFoodOrderingSystem.Controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.OnlineFoodOrderingSystem.Entity.Cart;
import com.example.OnlineFoodOrderingSystem.Service.CartService;

@RestController
@RequestMapping("/carts")
public class CartController {

    private final CartService cartservice;

    public CartController(CartService cartservice) {
        this.cartservice = cartservice;
    }

    @PostMapping
    public ResponseEntity<Cart> addToCart(@RequestParam Long id,
                                          @RequestParam Long foodItemId,
                                          @RequestParam int quantity) {

        Cart cart = cartservice.addToCart(id, foodItemId, quantity);
        return ResponseEntity.ok(cart);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<Cart>> getByCartId(@PathVariable Long userId) {

        List<Cart> cart = cartservice.getByUserId(userId);
        return ResponseEntity.ok(cart);
    }

    @PutMapping("/{cartId}")
    public ResponseEntity<Cart> update(@PathVariable Long cartId,
                                       @RequestParam int quantity) {

        Cart cart = cartservice.updateQuantity(cartId, quantity);
        return ResponseEntity.ok(cart);
    }

    @DeleteMapping("/item/{cartId}")
    public ResponseEntity<String> removeItem(@PathVariable Long cartId) {

        cartservice.removeItem(cartId);
        return ResponseEntity.ok("Cart item deleted successfully");
    }

    @DeleteMapping("/user/{userId}")
    public ResponseEntity<String> clearCart(@PathVariable Long id) {

        cartservice.clearCart(id);
        return ResponseEntity.ok("Cart cleared successfully");
    }
}