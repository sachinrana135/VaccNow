package com.sachin.VaccNow.Service

import com.sachin.VaccNow.BRANCH_CLOSING_TIME
import com.sachin.VaccNow.BRANCH_START_TIME
import com.sachin.VaccNow.DTO.*
import com.sachin.VaccNow.Entity.Branch
import com.sachin.VaccNow.Entity.BranchVaccine
import com.sachin.VaccNow.Entity.Schedule
import com.sachin.VaccNow.Entity.Vaccine
import com.sachin.VaccNow.Utils.toTimeStamp
import java.sql.Timestamp

val mockedTimeStamp: Timestamp = Timestamp(1614885291675)

val mockBranchEntity = Branch(id = 1,
        name = "RML Hospital",
        location = "Delhi",
        dateCreated = "2021-03-09 13:00".toTimeStamp(),
        dateModified = "2021-03-09 13:00".toTimeStamp())

val mockVaccineEntity = Vaccine(id = 1,
        name = "Covaxin",
        cost = 1000.0,
        dateCreated = "2021-03-09 13:00".toTimeStamp(),
        dateModified = "2021-03-09 13:00".toTimeStamp())

val mockBranchVaccineEntity = BranchVaccine(id = 1,
        branch = mockBranchEntity,
        vaccine = mockVaccineEntity,
        count = 100,
        dateCreated = "2021-03-09 13:00".toTimeStamp(),
        dateModified = "2021-03-09 13:00".toTimeStamp())

val mockBranchVaccinesEntity = listOf<BranchVaccine>(mockBranchVaccineEntity)

val mockVaccineDTO = VaccineDTO(
        id = 1,
        name = "Covaxin",
        cost = 1000.0,
        quantity = 100
)
val mockVaccinesDTO = listOf<VaccineDTO>(
        mockVaccineDTO
)

val mockBranchVaccineDTO = BranchVaccineDTO(
        branchId = 1,
        name = "RML Hospital",
        vaccines = mockVaccinesDTO
)

val mockBranchVaccinesDTO = listOf<BranchVaccineDTO>(mockBranchVaccineDTO)

val mockBranchDTO = BranchDTO(id = 1,
        name = "RML Hospital",
        location = "Delhi")

val mockSlotDT = SlotDTO(
        branchID = 1,
        branchName = "RML Hospital",
        openingTime = BRANCH_START_TIME,
        closingTime = BRANCH_CLOSING_TIME,
        slots = listOf<String>()
)

var mockBranchesEntity = listOf<Branch>(
        mockBranchEntity
)

var mockBranchesDTO = listOf<BranchDTO>(
        mockBranchDTO
)

var mockScheduleRequestDto = ScheduleRequestDTO(
        email = "user5@example.com",
        slot = "2021-03-09 13:00",
        vaccineId = 1,
        branchId = 1,
        paymentType = "cash"
)

var mockScheduleEntity = Schedule(
        id = 0,
        email = "user5@example.com",
        slot = "2021-03-09 13:00".toTimeStamp(),
        branch = mockBranchEntity,
        vaccine = mockVaccineEntity,
        paymentType = "cash",
        status = "confirmed",
        dateCreated = mockedTimeStamp,
        dateModified = mockedTimeStamp
)

var mockScheduleEntities = listOf<Schedule>(mockScheduleEntity)

var mockScheduleResponseDTO = ScheduleResponseDTO(
        scheduleId = mockScheduleEntity.id,
        email = mockScheduleEntity.email,
        slot = mockScheduleEntity.slot.toString(),
        branchId = mockBranchEntity.id,
        branchName = mockBranchEntity.name,
        vaccineId = mockVaccineEntity.id,
        vaccineName = mockVaccineEntity.name,
        paymentType = mockScheduleEntity.paymentType,
        status = mockScheduleEntity.status,
        lastModified = mockScheduleEntity.dateModified.toString()
)

var mockScheduleResponseDTOs = listOf<ScheduleResponseDTO>(mockScheduleResponseDTO)



