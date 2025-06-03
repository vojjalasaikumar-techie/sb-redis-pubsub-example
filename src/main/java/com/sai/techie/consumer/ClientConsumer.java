package com.sai.techie.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.sai.techie.config.MessagingConfig;
import com.sai.techie.dto.PaymentRequest;

@Component
public class ClientConsumer {
	
	@RabbitListener(queues = MessagingConfig.QUEUE)
	public void consumePaymentFromQueue(PaymentRequest paymentRequest) {
		System.out.println("Payment received from bank.. Thanks..."+paymentRequest);
	}

}
