package com.sachin.vaccnow.controller


import com.sachin.vaccnow.dto.BranchDTO
import com.sachin.vaccnow.dto.SlotDTO
import com.sachin.vaccnow.service.BranchService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.constraints.NotBlank


@RestController
@RequestMapping("/branch")
class BranchController(private val branchService: BranchService) {

    @GetMapping
    fun getAllBranch(): List<BranchDTO> {
        return branchService.getAllBranch()
    }

    @GetMapping("/slots/{branchId}")
    fun getBranchSlots(@PathVariable("branchId") @NotBlank branchId: Long): SlotDTO {
        return branchService.getSlots(branchId)

    }
}