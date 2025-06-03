package com.sai.techie.publisher;

import java.time.LocalDate;
import java.util.UUID;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sai.techie.config.MessagingConfig;
import com.sai.techie.dto.PaymentRequest;

@Service
public class PaymentService {

	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	public String doPayment(PaymentRequest paymentRequest) {
		paymentRequest.setTransactionId(UUID.randomUUID().toString());
		paymentRequest.setTxDate(LocalDate.now());
		
		rabbitTemplate.convertAndSend(MessagingConfig.EXCHAGNE, MessagingConfig.ROUTING_KEY, paymentRequest);
		return "Message intiated successfully...";
		
	}
}
