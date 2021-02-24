package com.inabottle.treasure.infrastructure.data_sources

import com.inabottle.treasure.infrastructure.repositories.TreasureHuntEntity
import org.springframework.stereotype.Component
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono


interface TreasureHuntLocalDataSource {
    fun save(entity : TreasureHuntEntity) :  Mono<TreasureHuntEntity>

    fun loadAll() : Flux<TreasureHuntEntity>
}


@Component
class TreasureHuntLocalDataSourceImp(private val treasureHuntMongoDataSource : TreasureHuntMongoDataRepository) :  TreasureHuntLocalDataSource {

    override fun save(entity: TreasureHuntEntity) :  Mono<TreasureHuntEntity> {
        println("chegouc")
        val ret =treasureHuntMongoDataSource.save(entity)
        ret.map {println( it.id )}
    return ret}

    override fun loadAll() : Flux<TreasureHuntEntity> {
        val t= treasureHuntMongoDataSource.findAll()
        return t
    }

}
