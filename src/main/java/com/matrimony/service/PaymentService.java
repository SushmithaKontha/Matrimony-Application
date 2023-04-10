package com.matrimony.service;

import java.util.List;

import com.matrimony.entity.Payment;



public interface PaymentService {

	Payment addPayment(Payment payment);

	List<Payment> getAllPayments();

	Payment getPaymentById(int id);
	


	Payment updatePayment(Payment payment, int id);

	

}
