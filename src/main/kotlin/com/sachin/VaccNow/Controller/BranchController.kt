package com.sachin.VaccNow.Controller


import com.sachin.VaccNow.Entity.Branch
import com.sachin.VaccNow.Service.BranchService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/branch")
class BranchController (private val branchService: BranchService) {
    @GetMapping
    fun getAllBranch(): List<Branch> {
        return (branchService.getAllBranch())
       // return listOf<Branch>(Branch(id = 1, name = "test", location = Location.DELHI.value, dateCreated = "test", dateModified = "test"))
    }
}