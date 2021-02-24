package com.inabottle.treasure.infrastructure.repositories

import com.inabottle.treasure.domain.model.ConfigReward
import com.inabottle.treasure.domain.model.LockedFeature
import com.inabottle.treasure.domain.model.Step
import com.inabottle.treasure.domain.model.TreasureHunt
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.math.BigDecimal
import java.time.LocalDateTime
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
        val startDate : LocalDateTime,
        val endDate : LocalDateTime,
        val userCreateId : UUID,
        val amountOfPoints : BigDecimal ?
){
        fun toDomainModel() = TreasureHunt(
                id = id,
                steps = steps,
                password = password,
                tipToFirstStep = tipToFirstStep,
                commonRewards = commonRewards,
                especificRewards = especificRewards,
                maxWinners = maxWinners,
                startDate = startDate,
                endDate = endDate,
                userCreateId = userCreateId,
                amountOfPoints = amountOfPoints
        )
}

fun TreasureHunt.toEntity() = TreasureHuntEntity(
        id = id,
        steps = steps,
        password = password,
        tipToFirstStep = tipToFirstStep,
        commonRewards = commonRewards,
        especificRewards = especificRewards,
        maxWinners = maxWinners,
        startDate = startDate,
        endDate = endDate,
        userCreateId = userCreateId,
        amountOfPoints = amountOfPoints
)