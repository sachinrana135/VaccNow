package com.sachin.VaccNow.Service.Interface

import com.sachin.VaccNow.DTO.BranchVaccineDTO
import com.sachin.VaccNow.DTO.BranchVaccinesDTO

interface IBranchVaccineService {
    fun getAllVaccinesPerBranch() : BranchVaccinesDTO
    fun getAllVaccinesByBranchId(branchId:Long) : BranchVaccineDTO
}