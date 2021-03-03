package com.sachin.VaccNow.Service.Interface

import com.sachin.VaccNow.Entity.Branch

interface IBranchService {
    fun getAllBranch() : List<Branch>
}