package com.sai.techie.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sai.techie.dto.PaymentRequest;
import com.sai.techie.publisher.PaymentService;

@RestController
public class PaymentController {

	@Autowired
	private PaymentService paymentService;
	
	@PostMapping("/paymentToBank")
	public String doPaymentfromController(@RequestBody PaymentRequest paymentRequest) {
		return paymentService.doPayment(paymentRequest);
		
	}
}
