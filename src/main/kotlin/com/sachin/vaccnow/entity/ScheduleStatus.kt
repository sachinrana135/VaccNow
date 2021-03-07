package com.sachin.vaccnow.entity

enum class ScheduleStatus(val value:String) {
    CONFIRMED ("confirmed"),
    APPLIED("applied"),
    CANCELLED("cancelled");

    companion object {
        fun from(s: String): ScheduleStatus? = values().find { it.value == s }
    }
}