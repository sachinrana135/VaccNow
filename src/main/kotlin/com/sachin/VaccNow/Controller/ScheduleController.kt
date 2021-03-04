package com.sachin.VaccNow.Controller

import com.sachin.VaccNow.DTO.ScheduleDTO
import com.sachin.VaccNow.Service.ScheduleService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/schedule")
class ScheduleController(private val scheduleService: ScheduleService) {

    @PostMapping
    fun scheduleVaccine(@RequestBody scheduleDTO: ScheduleDTO): String {
        return scheduleService.scheduleVaccination(scheduleDTO)
    }
}