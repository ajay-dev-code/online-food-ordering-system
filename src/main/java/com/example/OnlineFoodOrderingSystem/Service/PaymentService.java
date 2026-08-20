package com.example.OnlineFoodOrderingSystem.Service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.OnlineFoodOrderingSystem.Entity.Order;
import com.example.OnlineFoodOrderingSystem.Entity.OrderStatus;
import com.example.OnlineFoodOrderingSystem.Entity.Payment;
import com.example.OnlineFoodOrderingSystem.Entity.PaymentMethod;
import com.example.OnlineFoodOrderingSystem.Entity.PaymentStatus;
import com.example.OnlineFoodOrderingSystem.Repository.OrderRepository;
import com.example.OnlineFoodOrderingSystem.Repository.PaymentRepository;

@Service
public class PaymentService {
	private final OrderRepository orderrepo;
	private final PaymentRepository paymentrepo;

	public PaymentService(OrderRepository orderrepo, PaymentRepository paymentrepo) {
		this.orderrepo = orderrepo;
		this.paymentrepo = paymentrepo;
	}

	public Payment createPayment(Long orderId, PaymentMethod paymentMethod) {
		Order order = orderrepo.findById(orderId)
				.orElseThrow(() -> new RuntimeException(" Order  not found with id " + orderId));
		Payment payment = new Payment();
		Double amount = order.getTotalamount();
		if (amount == null) {
			amount = 0.0;
		}
		payment.setOrder(order);
		payment.setAmount(amount);
		payment.setPaymentMethod(paymentMethod);
		payment.setPaymentStatus(PaymentStatus.SUCCESS);
		payment.setPaymentTime(LocalDateTime.now());

		return paymentrepo.save(payment);
	}

	public List<Payment> findPaymentStatus(PaymentStatus status) {
		return paymentrepo.findByPaymentStatus(status);
	}

	public Payment getPaymentById(Long paymentId) {
		return paymentrepo.findById(paymentId)
				.orElseThrow(() -> new RuntimeException("Payment not found with id " + paymentId));
	}

	public Payment updatePaymentStatus(Long id, PaymentStatus status) {

		Payment payment = getPaymentById(id);

		payment.setPaymentStatus(status);

		if (status == PaymentStatus.SUCCESS) {
			Order order = payment.getOrder();
			order.setStatus(OrderStatus.CONFIRMED);
			orderrepo.save(order);
		}

		return paymentrepo.save(payment);
	}

}
