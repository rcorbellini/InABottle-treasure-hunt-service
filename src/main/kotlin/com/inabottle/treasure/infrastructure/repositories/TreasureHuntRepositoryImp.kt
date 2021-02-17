package com.inabottle.treasure.infrastructure.repositories

import com.inabottle.treasure.domain.model.TreasureHunt
import com.inabottle.treasure.domain.repositories.TreasureHuntRepository
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

class TreasureHuntRepositoryImp : TreasureHuntRepository{
    override fun save(model: TreasureHunt): Mono<TreasureHunt> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun loadAll(): Flux<TreasureHunt> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}