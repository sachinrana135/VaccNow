package com.sachin.VaccNow.Service

import com.sachin.VaccNow.Entity.Branch
import com.sachin.VaccNow.Repository.BranchRepository
import com.sachin.VaccNow.Service.Interface.IBranchService
import org.springframework.stereotype.Service

@Service
class BranchService(private val branchRepository: BranchRepository) : IBranchService {

    override fun getAllBranch(): List<Branch> {
        //val list : MutableList<Branch> = mutableListOf<Branch>()
        return branchRepository.findAll().map{ it }
    }
}