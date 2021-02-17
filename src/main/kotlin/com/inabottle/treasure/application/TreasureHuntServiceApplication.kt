package com.inabottle.treasure.application

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.client.discovery.EnableDiscoveryClient
import org.springframework.cloud.netflix.eureka.EnableEurekaClient


@EnableEurekaClient
@EnableDiscoveryClient
@SpringBootApplication
class TreasureHuntServiceApplication

fun main(args: Array<String>) {
	runApplication<TreasureHuntServiceApplication>(*args)
}

