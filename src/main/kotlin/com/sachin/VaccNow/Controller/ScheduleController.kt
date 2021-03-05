package com.sachin.VaccNow.Controller

import com.sachin.VaccNow.DTO.ScheduleRequestDTO
import com.sachin.VaccNow.DTO.ScheduleResponseDTO
import com.sachin.VaccNow.Entity.ScheduleStatus
import com.sachin.VaccNow.Service.ScheduleService
import com.sachin.VaccNow.Utils.ScheduleFilter
import org.springframework.web.bind.annotation.*
import javax.validation.constraints.NotBlank


@RestController
@RequestMapping("/vaccination")
class ScheduleController(private val scheduleService: ScheduleService) {

    @RequestMapping("/schedule")
    @PostMapping
    fun scheduleVaccine(@RequestBody scheduleRequestDTO: ScheduleRequestDTO): Long {
        return scheduleService.scheduleVaccination(scheduleRequestDTO)
    }

    @RequestMapping("/apply/{scheduleId}")
    @PatchMapping
    fun applyVaccine(@PathVariable("scheduleId") @NotBlank id: Long): Long {
        return scheduleService.applyVaccination(id)
    }

    @GetMapping
    fun getVaccinations(@RequestParam(required = false) status: String?,
                        @RequestParam(required = false) branchId: Long?,
                        @RequestParam(required = false) fromDate: String?,
                        @RequestParam(required = false) toDate: String?): List<ScheduleResponseDTO> {

        val vaccinationStatus = status?.let { ScheduleStatus.from(status)?.value }
        val filter = ScheduleFilter(
                status = vaccinationStatus,
                branchId = branchId,
                from = fromDate,
                `to` = toDate
        )

        return scheduleService.getVaccinationByStatus(filter.buildFilterSpecification())
    }
}