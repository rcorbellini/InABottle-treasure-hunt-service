package com.inabottle.treasure.domain.repositories

import com.inabottle.treasure.domain.model.TreasureHunt
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono


interface TreasureHuntRepository{
    fun save(model : TreasureHunt) : Mono<TreasureHunt>

    fun loadAll() : Flux<TreasureHunt>
}