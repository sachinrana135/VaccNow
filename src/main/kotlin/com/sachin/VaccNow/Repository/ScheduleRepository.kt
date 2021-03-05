package com.sachin.VaccNow.Repository

import com.sachin.VaccNow.Entity.Schedule
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import java.util.*

interface ScheduleRepository : JpaRepository<Schedule, Long>, JpaSpecificationExecutor<Schedule> {
    fun findByEmail(email: String): Optional<Schedule>
}