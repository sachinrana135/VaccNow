package com.sachin.VaccNow.Repository

import com.sachin.VaccNow.Entity.BranchVaccine
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param

interface BranchVaccineRepository : CrudRepository<BranchVaccine, Long> {

    @Query("from BranchVaccine where branch.id = :branch_id")
    fun findVaccinesByBranchId(@Param("branch_id") branch_id: Long): List<BranchVaccine>

    @Query("from BranchVaccine where branch.id = :branch_id AND vaccine.id = :vaccine_id")
    fun findByVaccineIdAndBranchId(@Param("branch_id") branch_id: Long, @Param("vaccine_id") vaccine_id: Long): BranchVaccine

}