package com.inabottle.treasure.application.rest

import com.google.gson.Gson
import com.inabottle.treasure.domain.model.*
import com.inabottle.treasure.domain.serivce.TreasureHuntService
import kotlinx.coroutines.delay
import org.springframework.boot.json.GsonJsonParser
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.time.Duration
import java.time.LocalDate
import java.util.*


@RestController
class TreasureHuntController(private val treasureHuntService: TreasureHuntService) {

    @PostMapping("/treasure", produces = [MediaType.TEXT_EVENT_STREAM_VALUE])
    @ResponseStatus(HttpStatus.CREATED)
    fun save(@RequestBody treasureHuntInsertRequest : TreasureHuntInsertRequest) : Mono<TreasureHuntInsertResponse>{
        return treasureHuntService.save(treasureHuntInsertRequest.treasureHunt).map { TreasureHuntInsertResponse(id = it.id) }
    }

    @GetMapping("/treasure", produces = [MediaType.TEXT_EVENT_STREAM_VALUE])
    fun findAll() : Flux<TreasureHuntInsertResponse>{
        return treasureHuntService.loadAll().map { TreasureHuntInsertResponse(it.id) }
    }
    fun x(){

        var gson = Gson()
        val mock = TreasureHunt(
                id = UUID.randomUUID(),
                steps = listOf(
                        Step(
                                UUID.randomUUID(),
                                LockedFeature("xp", "x"),
                                Position(-50.000, 50.000),
                                "tip nex"
                        )
                ),
                commonRewards = listOf(UUID.randomUUID(),UUID.randomUUID()),
                startDate = LocalDate.of(2020, 10,1).atTime(20,20),
                endDate = LocalDate.of(2030, 6, 25).atTime(10,10),
                maxWinners = 10,
                password = LockedFeature(password = "jucap",tip="juca"),
                userCreateId = UUID.randomUUID(),
                tipToFirstStep = "vai juca",
                amountOfPoints = null,
                especificRewards = listOf(ConfigReward(position = 1,  idsRewards=listOf(UUID.randomUUID())))
        )

        var jsonString = gson.toJson(TreasureHuntInsertRequest(
                treasureHunt =  mock))
        treasureHuntService.save(mock)
        println(jsonString)
    }
    @GetMapping("/test", produces = [MediaType.TEXT_EVENT_STREAM_VALUE])
    fun go() : Flux<String>{
        return Flux.interval(Duration.ofSeconds(0), Duration.ofSeconds(3)).map {
            "teste"
        }.take(3)
    }

}


data class TreasureHuntInsertRequest(
        val treasureHunt : TreasureHunt
)

data class TreasureHuntInsertResponse(
        val id: UUID
)
