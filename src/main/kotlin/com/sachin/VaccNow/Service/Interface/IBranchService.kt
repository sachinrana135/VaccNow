package com.sachin.VaccNow.Service.Interface

import com.sachin.VaccNow.DTO.BranchDTO

interface IBranchService {
    fun getAllBranch() : List<BranchDTO>
}