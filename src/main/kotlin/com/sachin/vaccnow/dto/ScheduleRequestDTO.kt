package com.sachin.vaccnow.dto

data class ScheduleRequestDTO(
        val email: String,
        val slot: String,
        val vaccineId: Long,
        val branchId: Long,
        val paymentType: String
)