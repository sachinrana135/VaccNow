package com.sachin.VaccNow.DTO


data class BranchVaccineDTO(
        val branchId: Long,
        val name: String,
        val vaccines: List<VaccineDTO>
)