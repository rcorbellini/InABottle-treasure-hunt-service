package com.inabottle.treasure.infrastructure.data_sources

import com.inabottle.treasure.infrastructure.entities.TreasureHuntEntity
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import java.util.*

//TODO
interface TreasureHuntLocalDataSource{
    fun save(entity : TreasureHuntEntity)

    fun loadAll()
}

interface TrasureHuntMongoDataSource:  TreasureHuntLocalDataSource{

    override fun save(entity: TreasureHuntEntity) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun loadAll() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}

interface  teste : ReactiveMongoRepository<TreasureHuntEntity, UUID>