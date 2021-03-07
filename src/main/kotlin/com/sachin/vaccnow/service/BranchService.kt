package com.sachin.vaccnow.service

import com.sachin.vaccnow.*
import com.sachin.vaccnow.dto.BranchDTO
import com.sachin.vaccnow.dto.SlotDTO
import com.sachin.vaccnow.repository.BranchRepository
import com.sachin.vaccnow.repository.ScheduleRepository
import com.sachin.vaccnow.service.Interface.IBranchService
import com.sachin.vaccnow.utils.ScheduleFilter
import com.sachin.vaccnow.utils.branchEntityToDTOMapper
import com.sachin.vaccnow.utils.toTimeStamp
import com.sachin.vaccnow.error.RecordNotFoundException
import org.springframework.data.repository.findByIdOrNull
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
        val branch = branchRepository.findByIdOrNull(branchId) ?: throw RecordNotFoundException()
        val dateTimeFormatter = DateTimeFormatter.ofPattern(DATE_TIME_FORMAT)
        val slots = mutableListOf<String>()
        var from: LocalTime = BRANCH_START_TIME.toTimeStamp(TIME_FORMAT).toLocalDateTime().toLocalTime()
        var currentTime = LocalTime.now()
        from = if (currentTime > from) currentTime else from
        val to: LocalTime = BRANCH_CLOSING_TIME.toTimeStamp(TIME_FORMAT).toLocalDateTime().toLocalTime()

        while (from.isBefore(to.plusMinutes(1))) {
            slots.add(LocalDateTime.now().withHour(from.hour).withMinute(from.minute).format(dateTimeFormatter))
            from = from.plusMinutes(SLOT_INTERVAL_MINUTES)
        }

        val bookedSlots = scheduleRepository.findAll(ScheduleFilter(branchId = branchId,
                from = SimpleDateFormat(DATE_FORMAT).format(Date()),
                `to` = SimpleDateFormat(DATE_FORMAT).format(Date())).buildFilterSpecification()
        ).map {
            it.slot.toLocalDateTime().format(dateTimeFormatter)
        }
        slots.removeAll(bookedSlots)
        return SlotDTO(
                branchID = branch.id,
                branchName = branch.name,
                openingTime = BRANCH_START_TIME,
                closingTime = BRANCH_CLOSING_TIME,
                slots = slots
        )

    }
}