package com.sachin.VaccNow.Controller

import com.sachin.VaccNow.DTO.BranchVaccineDTO
import com.sachin.VaccNow.DTO.BranchVaccinesDTO
import com.sachin.VaccNow.Service.BranchVaccineService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/branch-vaccine")
class BranchVaccineController(private val branchVaccineService: BranchVaccineService) {

    @GetMapping
    fun getAllVaccinesPerBranch(): BranchVaccinesDTO {
        return (branchVaccineService.getAllVaccinesPerBranch())
    }

    @GetMapping("/{branchId}")
    fun getAllVaccinesByBranchId(@PathVariable("branchId") branchId: Long): BranchVaccineDTO {
        return (branchVaccineService.getAllVaccinesByBranchId(branchId))
    }
}