package com.inabottle.treasure.domain.model

import java.util.*


data class Step(
        val id: UUID?,
        val password: LockedFeature?,
        val position: Position,
        val tipToNextStep : String
){

    init{
        require(tipToNextStep.isNotBlank()){
            "tipToNextStep must not be blank"
        }
    }
}