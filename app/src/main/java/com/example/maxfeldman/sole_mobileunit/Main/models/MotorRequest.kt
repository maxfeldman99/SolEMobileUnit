package com.max.michael.robotviewunit.models

class MotorRequest(val motorId:String, val port: String, val speed:String, val angle: String,
    val delayAmount : String = "") : RobotRequest()
{
    init {
        type = "Motor"
    }
}