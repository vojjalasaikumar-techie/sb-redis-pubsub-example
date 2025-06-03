package com.sai.techie.config;



import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MessagingConfig {

	//first create a Queue
	//second create a exchange
	//third binding queue and exchange with a routing queue
	//fourth create a message converter- it rabbitmq it is always convert to json 
	//fourth create a template
	
	public static final String QUEUE = "javatechie-queue";
	public static final String EXCHAGNE = "javatechie-exchange";
	public static final String ROUTING_KEY = "javatechie-routing-key";
	
	@Bean
	public Queue queue() {
		return new Queue(QUEUE);
	}
	
	@Bean
	public TopicExchange topicExchange() {
		return new TopicExchange(EXCHAGNE);
	}
	
	@Bean
	public Binding binding(Queue queue, TopicExchange topicExchange) {
		return BindingBuilder
				.bind(queue)
				.to(topicExchange)
				.with(ROUTING_KEY);
	}
	
	@Bean
	public MessageConverter converter() {
		return new Jackson2JsonMessageConverter();
	}
	
	@Bean
	public AmqpTemplate template(ConnectionFactory connectionFactory) {
		final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
		rabbitTemplate.setMessageConverter(converter());
		return rabbitTemplate;
	}
}
