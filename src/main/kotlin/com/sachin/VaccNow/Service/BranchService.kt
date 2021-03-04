package com.sachin.VaccNow.Service

import com.sachin.VaccNow.*
import com.sachin.VaccNow.DTO.BranchDTO
import com.sachin.VaccNow.DTO.ScheduleFilter
import com.sachin.VaccNow.DTO.SlotDTO
import com.sachin.VaccNow.Repository.BranchRepository
import com.sachin.VaccNow.Repository.ScheduleRepository
import com.sachin.VaccNow.Service.Interface.IBranchService
import com.sachin.VaccNow.Utils.branchEntityToDTOMapper
import com.sachin.VaccNow.Utils.toTimeStamp
import org.springframework.stereotype.Service
import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.time.LocalTime
import java.time.format.DateTimeFormatter
import java.util.*

@Service
class BranchService(private val branchRepository: BranchRepository,
                    private val scheduleRepository: ScheduleRepository) : IBranchService {

    override fun getAllBranch(): List<BranchDTO> {
        return branchRepository.findAll().map { branchEntityToDTOMapper(it) }
    }

    override fun getSlots(branchId: Long): SlotDTO {
        val dateTimeFormatter = DateTimeFormatter.ofPattern(DATE_TIME_FORMAT)
        val branch = branchRepository.findById(branchId)
        val slots = mutableListOf<String>()
        if (branch.isPresent) {
            var from: LocalTime = BRANCH_START_TIME.toTimeStamp(TIME_FORMAT).toLocalDateTime().toLocalTime()
            var currentTime = LocalTime.now()

            from = if (currentTime > from) currentTime else from

            val to: LocalTime = BRANCH_CLOSING_TIME.toTimeStamp(TIME_FORMAT).toLocalDateTime().toLocalTime()

            while (from.isBefore(to.plusMinutes(1))) {
                slots.add(LocalDateTime.now().withHour(from.hour).withMinute(from.minute).format(dateTimeFormatter))
                from = from.plusMinutes(SLOT_INTERVAL_MINUTES)
            }

        }

        val bookedSlots = scheduleRepository.findAll(ScheduleFilter(branchId = branchId,
                from = SimpleDateFormat(DATE_FORMAT).format(Date()),
                `to` = SimpleDateFormat(DATE_FORMAT).format(Date())).buildFilterSpecification()
        ).map {
            it.slot.toLocalDateTime().format(dateTimeFormatter)
        }
        slots.removeAll(bookedSlots)
        return SlotDTO(
                branchID = branch.get().id,
                branchName = branch.get().name,
                openingTime = BRANCH_START_TIME,
                closingTime = BRANCH_CLOSING_TIME,
                slots = slots
        )

    }
}