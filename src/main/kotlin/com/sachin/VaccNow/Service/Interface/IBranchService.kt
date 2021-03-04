package com.sachin.VaccNow.Service.Interface

import com.sachin.VaccNow.DTO.BranchDTO
import com.sachin.VaccNow.DTO.SlotDTO

interface IBranchService {
    fun getAllBranch(): List<BranchDTO>
    fun getSlots(branchId: Long): SlotDTO
}