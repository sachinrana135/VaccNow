package com.sachin.vaccnow.dto


data class BranchVaccineDTO(
        val branchId: Long,
        val name: String,
        val vaccines: List<VaccineDTO>
)