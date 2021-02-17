package com.inabottle.treasure.domain.model

import java.util.*

data class ConfigReward(
        val poistion : Int,
        val idsRewards : List<UUID>
){
    init {
        require(idsRewards.isNotEmpty()){
            "Rewards of config must not be empty"
        }
        require(poistion <= 0){
            "Position must be greater then zero"
        }
    }
}