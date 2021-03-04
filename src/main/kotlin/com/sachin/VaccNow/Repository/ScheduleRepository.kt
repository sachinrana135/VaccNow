package com.sachin.VaccNow.Repository

import com.sachin.VaccNow.Entity.Schedule
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.springframework.data.repository.query.Param

interface ScheduleRepository : JpaRepository<Schedule, Long>, JpaSpecificationExecutor<Schedule> {
    fun findByStatus(@Param("status") status: String): List<Schedule>
    fun findByBranchAndStatus(@Param("branch_id") branch_id: Long, @Param("status") status: String): List<Schedule>
    //fun filterVaccination(filter: VaccinationFilter):List<Schedule>
}