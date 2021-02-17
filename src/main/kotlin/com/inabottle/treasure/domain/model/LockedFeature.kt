package com.inabottle.treasure.domain.model

data class LockedFeature(
        val password: String,
        val tip: String
){
    init {
        require(tip.isNotBlank()){
            "Tip must not be empty"
        }
        require(password.isNotBlank()){
            "Password must not be empty"
        }
    }
}