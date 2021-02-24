package com.inabottle.treasure.infrastructure.data_sources

import com.inabottle.treasure.infrastructure.adapters.EventProducer
import com.inabottle.treasure.infrastructure.repositories.TreasureHuntEntity
import org.springframework.stereotype.Component


interface TreasureHuntProducer{
    fun treasureHuntSaved(model : TreasureHuntEntity)
}

@Component
class TreasureHuntProducerImp(private val producer: EventProducer) : TreasureHuntProducer{

    override fun treasureHuntSaved(entity: TreasureHuntEntity){
        producer.send(EXCHANGE,   ROUTING_KEY ,  entity)
    }

    companion object{
        const val EXCHANGE = "treasure-hunt"
        const val ROUTING_KEY = "treasure-hunt.created"
    }
}