package com.matrimony.service.impl;



import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matrimony.dao.PaymentDao;
import com.matrimony.entity.Payment;
import com.matrimony.exception.ResourceNotFoundException;
import com.matrimony.service.PaymentService;



@Service
public class PaymentServiceImpl implements PaymentService{
	
	@Autowired
		private PaymentDao paymentDao;
		
		public PaymentServiceImpl(PaymentDao paymentDao) {
			super();
			this.paymentDao = paymentDao;
		}


		@Override
		public Payment addPayment(Payment payment) {
			return paymentDao.save(payment);
			
		}


		@Override
		public List<Payment>getAllPayments(){
			return paymentDao.findAll();
		}
		
		
		@Override
		public Payment getPaymentById(int id) {
			
			return paymentDao.findById(id).orElseThrow(() ->
new ResourceNotFoundException("Payment not found","Id",id));
				
			}


		@Override
		public Payment updatePayment(Payment payment, int id) { 
			Payment pay = paymentDao.findById(id).orElseThrow(
					()-> new ResourceNotFoundException("Payment not found", "Id", id));

			pay.setCandidateName(payment.getCandidateName());
			pay.setBankName(payment.getBankName());
			pay.setAccountNo(payment.getAccountNo());
			pay.setIfscCode(payment.getIfscCode());
			
			
			paymentDao.save(pay);
			return pay;
		}
		


	
}