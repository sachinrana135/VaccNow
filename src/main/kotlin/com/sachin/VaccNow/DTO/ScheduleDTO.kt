package com.sachin.VaccNow.DTO

data class ScheduleDTO(
        val email: String,
        val from: String,
        val to: String,
        val vaccineId: Long,
        val branchId: Long,
        val paymentType: String
)