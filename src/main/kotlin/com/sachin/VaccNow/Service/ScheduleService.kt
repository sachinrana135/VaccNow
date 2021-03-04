package com.sachin.VaccNow.Service

import com.sachin.VaccNow.DTO.ScheduleDTO
import com.sachin.VaccNow.Entity.PaymentMethod
import com.sachin.VaccNow.Entity.Schedule
import com.sachin.VaccNow.Entity.ScheduleStatus
import com.sachin.VaccNow.Repository.BranchRepository
import com.sachin.VaccNow.Repository.ScheduleRepository
import com.sachin.VaccNow.Repository.VaccineRepository
import com.sachin.VaccNow.Service.Interface.IScheduleService
import com.sachin.VaccNow.Utils.toTimeStamp
import org.springframework.stereotype.Service
import java.sql.Timestamp

@Service
class ScheduleService(private val scheduleRepository: ScheduleRepository,
                      private val branchRepository: BranchRepository,
                      private val vaccineRepository: VaccineRepository) : IScheduleService {
    override fun scheduleVaccination(scheduleDto: ScheduleDTO): String {

        val branch = branchRepository.findById(scheduleDto.branchId)
        val vaccine = vaccineRepository.findById(scheduleDto.vaccineId)

        //Todo handle exception here
        val paymentType = PaymentMethod.from(scheduleDto.paymentType)?.value!!

        val scheduleEntity = Schedule(
                email = scheduleDto.email,
                from = scheduleDto.from.toTimeStamp(),
                `to` = scheduleDto.to.toTimeStamp(),
                branch = branch.get(),
                vaccine = vaccine.get(),
                paymentType = paymentType,
                status = ScheduleStatus.CONFIRMED.value,
                dateCreated = Timestamp(System.currentTimeMillis()),
                dateModified = Timestamp(System.currentTimeMillis())
        )

        return scheduleRepository.save(scheduleEntity).id.toString()
    }

}