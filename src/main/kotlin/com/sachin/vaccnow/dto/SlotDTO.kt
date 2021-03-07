package com.sachin.vaccnow.dto

data class SlotDTO(
        val branchID: Long,
        val branchName: String,
        val openingTime: String,
        val closingTime: String,
        val slots: List<String>
)