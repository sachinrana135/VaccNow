package com.sachin.vaccnow.service

import com.sachin.vaccnow.entity.ScheduleStatus
import com.sachin.vaccnow.repository.BranchRepository
import com.sachin.vaccnow.repository.BranchVaccineRepository
import com.sachin.vaccnow.repository.ScheduleRepository
import com.sachin.vaccnow.repository.VaccineRepository
import com.sachin.vaccnow.utils.DateTimeUtils
import com.sachin.vaccnow.utils.ScheduleFilter
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.*
import org.springframework.boot.test.context.SpringBootTest
import java.util.*


@SpringBootTest
class ScheduleServiceTest {

    @Mock
    lateinit var scheduleRepository: ScheduleRepository

    @Mock
    lateinit var branchRepository: BranchRepository

    @Mock
    lateinit var branchVaccineRepository: BranchVaccineRepository

    @Mock
    lateinit var vaccineRepository: VaccineRepository

    @Mock
    lateinit var certificateGeneratorService: CertificateGeneratorService

    @Mock
    lateinit var emailService: EmailService

    @Mock
    lateinit var dateTimeUtils: DateTimeUtils

    @InjectMocks
    lateinit var scheduleService: ScheduleService

    @Test
    fun `Schedule vaccination`() {

        val mockScheduleEntity = mockScheduleEntity.copy()
        `when`(branchRepository.findById(mockScheduleRequestDto.branchId)).thenReturn(Optional.of(mockBranchEntity))
        `when`(vaccineRepository.findById(mockScheduleRequestDto.vaccineId)).thenReturn(Optional.of(mockVaccineEntity))
        `when`(dateTimeUtils.getCurrentTimeStamp()).thenReturn(mockedTimeStamp)
        `when`(scheduleRepository.save(mockScheduleEntity)).thenReturn(mockScheduleEntity)
        var result = scheduleService.scheduleVaccination(mockScheduleRequestDto)
        verify(branchRepository, times(1)).findById(mockScheduleRequestDto.branchId)
        verify(vaccineRepository, times(1)).findById(mockScheduleRequestDto.vaccineId)
        verify(scheduleRepository, times(1)).save(mockScheduleEntity)
        verify(emailService, times(1)).sendEmail(mockScheduleEntity)
        verify(dateTimeUtils, times(2)).getCurrentTimeStamp()
        Assertions.assertEquals(0, result)
    }

    @Test
    fun `Apply vaccination`() {

        val scheduleId: Long = 0

        val mockBranchVaccineEntity = mockBranchVaccineEntity.copy()
        val mockScheduleEntity = mockScheduleEntity.copy()
        `when`(branchVaccineRepository.findByVaccineIdAndBranchId(mockScheduleEntity.branch.id, mockScheduleEntity.vaccine.id)).thenReturn(mockBranchVaccineEntity)
        `when`(scheduleRepository.findById(scheduleId)).thenReturn(Optional.of(mockScheduleEntity))
        `when`(dateTimeUtils.getCurrentTimeStamp()).thenReturn(mockedTimeStamp)

        val updatedEntity = mockScheduleEntity.apply {
            status = ScheduleStatus.APPLIED.value
            dateModified = mockedTimeStamp
        }

        `when`(scheduleRepository.save(updatedEntity)).thenReturn(updatedEntity)
        var result = scheduleService.applyVaccination(scheduleId)
        verify(branchVaccineRepository, times(1)).findByVaccineIdAndBranchId(mockScheduleEntity.branch.id, mockScheduleEntity.vaccine.id)
        verify(scheduleRepository, times(1)).findById(scheduleId)
        verify(scheduleRepository, times(1)).save(updatedEntity)
        verify(certificateGeneratorService, times(1)).generateCertificate(updatedEntity)
        verify(dateTimeUtils, times(1)).getCurrentTimeStamp()
        Assertions.assertEquals(0, result)
    }

    @Test
    fun `Get all applied vaccination per branch `() {
        val filter = ScheduleFilter(status = "applied", branchId = 1)
        val filterSpecification = filter.buildFilterSpecification()
        `when`(scheduleRepository.findAll(filterSpecification)).thenReturn(mockScheduleEntities)
        var result = scheduleService.getVaccinationByStatus(filterSpecification)
        verify(scheduleRepository, times(1)).findAll(filterSpecification)
        Assertions.assertEquals(mockScheduleResponseDTOs, result)
    }
}