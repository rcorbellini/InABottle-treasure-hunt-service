package com.inabottle.treasure.application.rest

import com.google.gson.Gson
import com.inabottle.treasure.domain.model.*
import com.inabottle.treasure.domain.serivce.TreasureHuntService
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.math.BigDecimal
import java.time.Instant
import java.util.*


@RestController
class TreasureHuntController(private val treasureHuntService: TreasureHuntService) {

    @PostMapping("/treasure", produces = [MediaType.TEXT_EVENT_STREAM_VALUE], consumes = [MediaType.APPLICATION_JSON_VALUE])
    @ResponseStatus(HttpStatus.CREATED)
    fun save(@RequestBody treasureHuntInsertRequest : TreasureHunt) : Mono<TreasureHunt>{
        return treasureHuntService.save(mock())
    }

    @GetMapping("/treasure", produces = [MediaType.TEXT_EVENT_STREAM_VALUE])
    fun stream() : Flux<TreasureHunt>{
        return treasureHuntService.loadAll()
    }
    fun mock(): TreasureHunt{

        var gson = Gson()
        val mock = TreasureHunt(
                id = UUID.randomUUID(),
                title = "title",
                description = "this is another treasure",
                steps = listOf(
                        Step(
                                UUID.randomUUID(),
                                "Step near lake",
                                LockedFeature("xp", "x"),
                                Position(-50.000, 50.000),
                                "tip nex"
                        )
                ),
                startPoint = Position(-50.000, 50.000),
                commonRewards = listOf(UUID.randomUUID(),UUID.randomUUID()),
                startDate = Instant.now(),
                endDate = Instant.now().plusMillis(10000),
                maxWinners = 10,
                lockedFeature = LockedFeature(password = "jucap",tip="juca"),
                userCreateId = UUID.randomUUID(),
                tipToFirstStep = "vai juca",
                amountOfPoints = BigDecimal(10),
                especificRewards = listOf(ConfigReward(position = 1,  idsRewards=listOf(UUID.randomUUID())))
        )

        var jsonString = gson.toJson(mock)

        println(jsonString)
        return mock
    }

}

//{"id":"ae6737ab-18b7-49c5-bfa3-4f2ff0b533e8","steps":[{"id":"627912d9-d424-4ff4-889d-b11e23b78f3c","password":{"password":"xp","tip":"x"},"position":{"latitude":-50.0000,"longitude":50.0000},"tipToNextStep":"tip nex"}],"password":{"password":"jucap","tip":"juca"},"tipToFirstStep":"vai juca","commonRewards":["23e40cfc-c7c5-4762-a32e-3bac799cc915","0668a412-3a43-404e-a1a4-f995194ff7ba"],"especificRewards":[{"position":1,"idsRewards":["3bbfe64c-da1b-4610-bd6b-ff3fb6cc11af"]}],"maxWinners":10,"startDate":"2021-02-26T02:25:42.578Z","endDate":"2021-02-26T02:25:52.578Z","userCreateId":"4650e2c7-56b3-4181-b6c8-3ca77ce00c89","amountOfPoints":null,"state":"processings"}
