package com.inabottle.treasure.infrastructure.data_sources

import com.inabottle.treasure.domain.model.TreasureHunt
import com.inabottle.treasure.infrastructure.adapters.EventProducer


interface TreasureHuntProducer{
    fun treasureHuntSaved(model : TreasureHunt)
}

class TreasureHuntProducerImp(private val producer: EventProducer) : TreasureHuntProducer{

    override fun treasureHuntSaved(model: TreasureHunt) {
        producer.send(EXCHANGE,   ROUTING_KEY ,  model)
    }

    companion object{
        const val EXCHANGE = "treasure-hunt"
        const val ROUTING_KEY = "treasure-hunt.created"
    }
}