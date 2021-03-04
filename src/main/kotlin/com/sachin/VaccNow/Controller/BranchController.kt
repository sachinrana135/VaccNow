package com.sachin.VaccNow.Controller


import com.sachin.VaccNow.DTO.BranchesDTO
import com.sachin.VaccNow.Service.BranchService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/branch")
class BranchController(private val branchService: BranchService) {
    @GetMapping
    fun getAllBranch(): BranchesDTO {
        return (BranchesDTO(branchService.getAllBranch()))
    }
}