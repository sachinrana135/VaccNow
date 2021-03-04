package com.sachin.VaccNow.Service.Interface

import com.sachin.VaccNow.DTO.ScheduleFilter
import com.sachin.VaccNow.DTO.ScheduleRequestDTO
import com.sachin.VaccNow.DTO.ScheduleResponseDTO

interface IScheduleService {
    fun scheduleVaccination(scheduleRequest: ScheduleRequestDTO): Long
    fun applyVaccination(scheduleId: Long): Long
    fun getVaccinationByStatus(filter: ScheduleFilter): List<ScheduleResponseDTO>
}