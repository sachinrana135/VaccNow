package com.sachin.VaccNow.Service

import com.sachin.VaccNow.DATE_TIME_FORMAT
import com.sachin.VaccNow.DTO.ScheduleRequestDTO
import com.sachin.VaccNow.DTO.ScheduleResponseDTO
import com.sachin.VaccNow.Entity.PaymentMethod
import com.sachin.VaccNow.Entity.Schedule
import com.sachin.VaccNow.Entity.ScheduleStatus
import com.sachin.VaccNow.Repository.BranchRepository
import com.sachin.VaccNow.Repository.BranchVaccineRepository
import com.sachin.VaccNow.Repository.ScheduleRepository
import com.sachin.VaccNow.Repository.VaccineRepository
import com.sachin.VaccNow.Service.Interface.IScheduleService
import com.sachin.VaccNow.Utils.ScheduleFilter
import com.sachin.VaccNow.Utils.toTimeStamp
import com.sachin.VaccNow.error.InvalidRequestException
import com.sachin.VaccNow.error.RecordNotFoundException
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import java.sql.Timestamp

@Service
class ScheduleService(private val scheduleRepository: ScheduleRepository,
                      private val branchRepository: BranchRepository,
                      private val branchVaccineRepository: BranchVaccineRepository,
                      private val vaccineRepository: VaccineRepository) : IScheduleService {
    override fun scheduleVaccination(scheduleRequestDto: ScheduleRequestDTO): Long {

        val branch = branchRepository.findByIdOrNull(scheduleRequestDto.branchId) ?: throw RecordNotFoundException()
        val vaccine = vaccineRepository.findByIdOrNull(scheduleRequestDto.vaccineId) ?: throw RecordNotFoundException()
        val paymentType = PaymentMethod.from(scheduleRequestDto.paymentType)?.value ?: throw InvalidRequestException()

        val scheduleEntity = Schedule(
                email = scheduleRequestDto.email,
                slot = scheduleRequestDto.slot.toTimeStamp(DATE_TIME_FORMAT),
                branch = branch,
                vaccine = vaccine,
                paymentType = paymentType!!,
                status = ScheduleStatus.CONFIRMED.value,
                dateCreated = Timestamp(System.currentTimeMillis()),
                dateModified = Timestamp(System.currentTimeMillis())
        )

        return scheduleRepository.save(scheduleEntity).id
    }

    override fun applyVaccination(scheduleId: Long): Long {
        val schedule = scheduleRepository.findByIdOrNull(scheduleId) ?: throw RecordNotFoundException()

        schedule.apply {
            status = ScheduleStatus.APPLIED.value
            dateModified = Timestamp(System.currentTimeMillis())
        }

        val branchVaccine = branchVaccineRepository.findByVaccineIdAndBranchId(schedule.branch.id, schedule.vaccine.id)
        branchVaccine.count -= 1
        branchVaccineRepository.save(branchVaccine)
        return scheduleRepository.save(schedule).id
    }

    override fun getVaccinationByStatus(filter: ScheduleFilter): List<ScheduleResponseDTO> {
        return scheduleRepository.findAll(filter.buildFilterSpecification()).map {
            ScheduleResponseDTO(
                    scheduleId = it.id,
                    email = it.email,
                    slot = it.slot.toString(),
                    vaccineId = it.vaccine.id,
                    vaccineName = it.vaccine.name,
                    branchId = it.branch.id,
                    branchName = it.branch.name,
                    paymentType = it.paymentType,
                    status = it.status,
                    lastModified = it.dateModified.toString()
            )
        }
    }


}