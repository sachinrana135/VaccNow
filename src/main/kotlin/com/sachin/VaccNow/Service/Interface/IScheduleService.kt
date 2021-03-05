package com.sachin.VaccNow.Service.Interface

import com.sachin.VaccNow.DTO.ScheduleRequestDTO
import com.sachin.VaccNow.DTO.ScheduleResponseDTO
import com.sachin.VaccNow.Entity.Schedule
import org.springframework.data.jpa.domain.Specification

interface IScheduleService {
    fun scheduleVaccination(scheduleRequest: ScheduleRequestDTO): Long
    fun applyVaccination(scheduleId: Long): Long
    fun getVaccinationByStatus(filter: Specification<Schedule>): List<ScheduleResponseDTO>
}