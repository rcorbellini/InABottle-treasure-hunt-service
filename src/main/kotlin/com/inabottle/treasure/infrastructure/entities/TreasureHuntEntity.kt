package com.inabottle.treasure.infrastructure.entities

import com.inabottle.treasure.domain.model.ConfigReward
import com.inabottle.treasure.domain.model.LockedFeature
import com.inabottle.treasure.domain.model.Step
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.math.BigDecimal
import java.util.*


@Document
data class TreasureHuntEntity(
        @Id
        val id: UUID,
        val steps: List<Step>,
        val password: LockedFeature?,
        val tipToFirstStep : String,
        val commonRewards : List<UUID>,
        val especificRewards : List<ConfigReward>,
        val maxWinners : Int?,
        val startDate : Date,
        val endDate : Date,
        val userCreateId : UUID,
        val amountOfPoints : BigDecimal ?
)