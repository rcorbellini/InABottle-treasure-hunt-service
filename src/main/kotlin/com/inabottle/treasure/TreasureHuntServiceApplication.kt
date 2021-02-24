package com.inabottle.treasure

import com.inabottle.treasure.infrastructure.data_sources.TreasureHuntMongoDataRepository
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.client.discovery.EnableDiscoveryClient
import org.springframework.cloud.netflix.eureka.EnableEurekaClient
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories


@EnableEurekaClient
@EnableDiscoveryClient
@SpringBootApplication
@ComponentScan
@EnableMongoRepositories
class TreasureHuntServiceApplication{
	@Bean
	fun rabbitTemplate(connectionFactory: ConnectionFactory): RabbitTemplate? {
		val rabbitTemplate = RabbitTemplate(connectionFactory)
		rabbitTemplate.messageConverter = producerJackson2MessageConverter()!!
		return rabbitTemplate
	}

	@Bean
	fun producerJackson2MessageConverter(): Jackson2JsonMessageConverter? {
		return Jackson2JsonMessageConverter()
	}
}

fun main(args: Array<String>) {
	runApplication<TreasureHuntServiceApplication>(*args)
}

