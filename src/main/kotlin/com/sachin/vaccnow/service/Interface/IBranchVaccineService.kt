package com.sachin.vaccnow.service.Interface

import com.sachin.vaccnow.dto.BranchVaccineDTO

interface IBranchVaccineService {
    fun getAllVaccinesPerBranch(): List<BranchVaccineDTO>
    fun getAllVaccinesByBranchId(branchId: Long): BranchVaccineDTO
}