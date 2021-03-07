package com.sachin.vaccnow.dto

data class ScheduleResponseDTO(
        val scheduleId: Long,
        val email: String,
        val slot: String,
        val vaccineId: Long,
        val vaccineName: String,
        val branchId: Long,
        val branchName: String,
        val paymentType: String,
        val lastModified: String,
        val status: String
)