package com.sachin.VaccNow.Service

import com.sachin.VaccNow.DTO.BranchDTO
import com.sachin.VaccNow.Utils.branchEntityToDTOMapper
import com.sachin.VaccNow.Repository.BranchRepository
import com.sachin.VaccNow.Service.Interface.IBranchService
import org.springframework.stereotype.Service

@Service
class BranchService(private val branchRepository: BranchRepository) : IBranchService {

    override fun getAllBranch(): List<BranchDTO> {
        return branchRepository.findAll().map{ branchEntityToDTOMapper(it) }
    }
}