package com.max.michael.robotviewunit.models

data class Request(val id : String, var sequence : ArrayList<MotorRequest>,
                   val sizeOfSequence: Int)
{

}