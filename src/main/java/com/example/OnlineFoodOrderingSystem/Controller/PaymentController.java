package com.example.OnlineFoodOrderingSystem.Controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.OnlineFoodOrderingSystem.Entity.Payment;
import com.example.OnlineFoodOrderingSystem.Entity.PaymentMethod;
import com.example.OnlineFoodOrderingSystem.Entity.PaymentStatus;
import com.example.OnlineFoodOrderingSystem.Service.PaymentService;

@RestController
@RequestMapping("/payments")
public class PaymentController {

	private final PaymentService paymentservice;

	public PaymentController(PaymentService paymentservice) {
		this.paymentservice = paymentservice;
	}

	@PostMapping("/{orderId}")
	public ResponseEntity<Payment> createPayment(@PathVariable Long orderId, @RequestBody Map<String, String> body) {

		PaymentMethod method = PaymentMethod.valueOf(body.get("paymentMethod"));

		Payment payment = paymentservice.createPayment(orderId, method);

		return ResponseEntity.status(HttpStatus.CREATED).body(payment);
	}

	@GetMapping("/status")
	public ResponseEntity<List<Payment>> getPaymentStatus(@RequestParam PaymentStatus status) {
		List<Payment> payments = paymentservice.findPaymentStatus(status);
		return ResponseEntity.ok(payments);
	}

	@GetMapping("/{paymentId}")
	public ResponseEntity<Payment> getByPaymentId(@PathVariable Long paymentId) {
		Payment payment = paymentservice.getPaymentById(paymentId);
		return ResponseEntity.ok(payment);
	}

	@PutMapping("/{paymentId}")
	public ResponseEntity<Payment> update(@PathVariable Long paymentId, @RequestBody PaymentStatus status) {
		Payment updatedPayment = paymentservice.updatePaymentStatus(paymentId, status);
		return ResponseEntity.ok(updatedPayment);
	}
}
