package com.inabottle.treasure.domain.serivce

import com.inabottle.treasure.domain.model.TreasureHunt
import com.inabottle.treasure.domain.repositories.TreasureHuntRepository
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono


@Service
class TreasureHuntService(private val treasureHuntRepository: TreasureHuntRepository){

    fun save(model : TreasureHunt) : Mono<TreasureHunt>{
        return treasureHuntRepository.save(model)
    }

    fun loadAll() : Flux<TreasureHunt>{
        return treasureHuntRepository.loadAll()
    }

}