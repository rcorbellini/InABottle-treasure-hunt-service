package com.inabottle.treasure.infrastructure.adapters

import org.springframework.amqp.rabbit.core.RabbitTemplate

interface EventProducer{
    fun send(exchange : String, routingKey : String, obj : Any)
}

class  RabbitProducer(private val rabbitTemplate : RabbitTemplate) : EventProducer{
    override fun send(exchange: String, routingKey: String, obj: Any) =
        rabbitTemplate.convertAndSend(exchange,   routingKey ,  obj)
}
