package com.sachin.vaccnow.service.Interface

import com.sachin.vaccnow.dto.ScheduleRequestDTO
import com.sachin.vaccnow.dto.ScheduleResponseDTO
import com.sachin.vaccnow.entity.Schedule
import org.springframework.data.jpa.domain.Specification

interface IScheduleService {
    fun scheduleVaccination(scheduleRequest: ScheduleRequestDTO): Long
    fun applyVaccination(scheduleId: Long): Long
    fun getVaccinationByStatus(filter: Specification<Schedule>): List<ScheduleResponseDTO>
}