package com.sachin.vaccnow.service.Interface

import com.sachin.vaccnow.dto.BranchDTO
import com.sachin.vaccnow.dto.SlotDTO

interface IBranchService {
    fun getAllBranch(): List<BranchDTO>
    fun getSlots(branchId: Long): SlotDTO
}