package com.sachin.VaccNow.Repository

import com.sachin.VaccNow.Entity.Schedule
import org.springframework.data.repository.CrudRepository

interface ScheduleRepository : CrudRepository<Schedule,Long>