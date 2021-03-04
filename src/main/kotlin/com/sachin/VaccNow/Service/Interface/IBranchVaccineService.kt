package com.sachin.VaccNow.Service.Interface

import com.sachin.VaccNow.DTO.BranchVaccineDTO

interface IBranchVaccineService {
    fun getAllVaccinesPerBranch(): List<BranchVaccineDTO>
    fun getAllVaccinesByBranchId(branchId: Long): BranchVaccineDTO
}