package com.inabottle.treasure.infrastructure.data_sources

import com.inabottle.treasure.infrastructure.repositories.TreasureHuntEntity
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import org.springframework.stereotype.Repository
import java.util.*


@Repository
interface TreasureHuntMongoDataRepository : ReactiveMongoRepository<TreasureHuntEntity, UUID>