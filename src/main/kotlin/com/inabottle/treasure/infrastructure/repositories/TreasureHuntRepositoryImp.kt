package com.inabottle.treasure.infrastructure.repositories

import com.inabottle.treasure.domain.model.TreasureHunt
import com.inabottle.treasure.domain.repositories.TreasureHuntRepository
import com.inabottle.treasure.infrastructure.data_sources.TreasureHuntLocalDataSource
import com.inabottle.treasure.infrastructure.data_sources.TreasureHuntProducer
import org.springframework.stereotype.Repository
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Repository
class TreasureHuntRepositoryImp(private val treasureHuntProducer : TreasureHuntProducer,
                                private val treasureHuntLocalDataSource : TreasureHuntLocalDataSource) : TreasureHuntRepository{
    override fun save(model: TreasureHunt): Mono<TreasureHunt> {
        return  treasureHuntLocalDataSource.save(model.toEntity()).map ( ::emmitSavedTreasureHunt)
    }

    private fun emmitSavedTreasureHunt(treasureHuntSaved : TreasureHuntEntity) = treasureHuntProducer.treasureHuntSaved(treasureHuntSaved).let { treasureHuntSaved.toDomainModel() }

    override fun loadAll(): Flux<TreasureHunt>  = treasureHuntLocalDataSource.loadAll().map { it.toDomainModel() }

}