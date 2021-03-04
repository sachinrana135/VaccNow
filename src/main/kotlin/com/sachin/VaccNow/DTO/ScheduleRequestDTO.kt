package com.sachin.VaccNow.DTO

data class ScheduleRequestDTO(
        val email: String,
        val slot: String,
        val vaccineId: Long,
        val branchId: Long,
        val paymentType: String
)