package com.inabottle.treasure.domain.serivce

import com.inabottle.treasure.domain.model.TreasureHunt
import com.inabottle.treasure.domain.repositories.TreasureHuntRepository
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono


interface TreasureHuntService{
    fun save(model : TreasureHunt) : Mono<TreasureHunt>

    fun loadAll() : Flux<TreasureHunt>
}

@Service
class TreasureHuntServiceImp(private val treasureHuntRepository: TreasureHuntRepository) : TreasureHuntService{

    override fun save(model : TreasureHunt) : Mono<TreasureHunt> {
        return treasureHuntRepository.save(model)
    }

    override fun loadAll() : Flux<TreasureHunt> {
        return treasureHuntRepository.loadAll()
    }

}