package com.max.michael.robotviewunit.models

data class DelayRequest(val id: String, val amount: Int): RobotRequest()
{
    init {
        type = "Delay"
    }

}