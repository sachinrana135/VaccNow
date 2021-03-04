package com.sachin.VaccNow.Repository

import com.sachin.VaccNow.Entity.BranchVaccine
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param

interface BranchVaccineRepository : CrudRepository<BranchVaccine, Long> {

    fun findAllVaccinesByBranchId(@Param("branch_id") branch_id: Long): List<BranchVaccine>

}