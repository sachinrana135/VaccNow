package com.sachin.vaccnow.service

import com.sachin.vaccnow.DATE_TIME_FORMAT
import com.sachin.vaccnow.dto.ScheduleRequestDTO
import com.sachin.vaccnow.dto.ScheduleResponseDTO
import com.sachin.vaccnow.entity.PaymentMethod
import com.sachin.vaccnow.entity.Schedule
import com.sachin.vaccnow.entity.ScheduleStatus
import com.sachin.vaccnow.repository.BranchRepository
import com.sachin.vaccnow.repository.BranchVaccineRepository
import com.sachin.vaccnow.repository.ScheduleRepository
import com.sachin.vaccnow.repository.VaccineRepository
import com.sachin.vaccnow.service.Interface.IScheduleService
import com.sachin.vaccnow.utils.DateTimeUtils
import com.sachin.vaccnow.utils.toTimeStamp
import com.sachin.vaccnow.error.DuplicateRecordFoundException
import com.sachin.vaccnow.error.InvalidRequestException
import com.sachin.vaccnow.error.RecordNotFoundException
import org.springframework.data.jpa.domain.Specification
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class ScheduleService(private val scheduleRepository: ScheduleRepository,
                      private val branchRepository: BranchRepository,
                      private val branchVaccineRepository: BranchVaccineRepository,
                      private val vaccineRepository: VaccineRepository,
                      private val certificateGeneratorService: CertificateGeneratorService,
                      private val emailService: EmailService,
                      private val dateTimeUtils: DateTimeUtils) : IScheduleService {


    override fun scheduleVaccination(scheduleRequestDto: ScheduleRequestDTO): Long {

        val branch = branchRepository.findByIdOrNull(scheduleRequestDto.branchId) ?: throw RecordNotFoundException()
        val vaccine = vaccineRepository.findByIdOrNull(scheduleRequestDto.vaccineId) ?: throw RecordNotFoundException()
        val paymentType = PaymentMethod.from(scheduleRequestDto.paymentType)?.value ?: throw InvalidRequestException()
        if(scheduleRepository.findByEmail(scheduleRequestDto.email).isPresent) throw DuplicateRecordFoundException()
        val scheduleEntity = Schedule(
                email = scheduleRequestDto.email,
                slot = scheduleRequestDto.slot.toTimeStamp(DATE_TIME_FORMAT),
                branch = branch,
                vaccine = vaccine,
                paymentType = paymentType,
                status = ScheduleStatus.CONFIRMED.value,
                dateCreated = dateTimeUtils.getCurrentTimeStamp(),
                dateModified = dateTimeUtils.getCurrentTimeStamp()
        )

        val result =  scheduleRepository.save(scheduleEntity)

        result?.let {
            emailService.sendEmail(result)
        }

        return result.id

    }

    override fun applyVaccination(scheduleId: Long): Long {
        val schedule = scheduleRepository.findByIdOrNull(scheduleId) ?: throw RecordNotFoundException()

        schedule.apply {
            status = ScheduleStatus.APPLIED.value
            dateModified = dateTimeUtils.getCurrentTimeStamp()
        }

        val branchVaccine = branchVaccineRepository.findByVaccineIdAndBranchId(schedule.branch.id, schedule.vaccine.id)
        branchVaccine.count -= 1
        branchVaccineRepository.save(branchVaccine)
        val result = scheduleRepository.save(schedule)

        result?.let {
            certificateGeneratorService.generateCertificate(result)
        }

        return result.id
    }

    override fun getVaccinationByStatus(filterSpecification: Specification<Schedule>): List<ScheduleResponseDTO> {
        return scheduleRepository.findAll(filterSpecification).map {
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