package com.sachin.VaccNow.Service.Interface

import com.sachin.VaccNow.DTO.ScheduleDTO

interface IScheduleService {
    fun scheduleVaccination(schedule: ScheduleDTO) : String
}