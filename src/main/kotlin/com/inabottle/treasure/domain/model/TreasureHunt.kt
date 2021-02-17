package com.inabottle.treasure.domain.model

import java.math.BigDecimal
import java.util.*

 data class TreasureHunt(
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
){

    init{
        require(steps.isNotEmpty()){
            "Steps are required, can't be empty"
        }

        require(startDate.before(endDate)){
            "Start date must be before end date"
        }

        require(maxWinners == null || maxWinners > 0){
            "Max winners must be null (for unlimited) or greater then 0"
        }

        require(tipToFirstStep.isNotBlank()){
            "tipToFirstStep must be not blank"
        }

        require(amountOfPoints == null || amountOfPoints.toDouble() > 0){
            "amountOfPoints must be null (not calculated yet) or greather then zero"
        }
    }

}