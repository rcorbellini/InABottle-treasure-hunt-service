package com.inabottle.treasure.infrastructure.repositories

import com.inabottle.treasure.domain.model.TreasureHunt
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import org.springframework.stereotype.Repository
import java.util.*


@Repository
interface TreasureHuntRepository : ReactiveMongoRepository<TreasureHunt, UUID>