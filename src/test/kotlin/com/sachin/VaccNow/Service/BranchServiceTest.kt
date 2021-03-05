package com.sachin.VaccNow.Service

import com.sachin.VaccNow.Repository.BranchRepository
import com.sachin.VaccNow.Repository.ScheduleRepository
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.*
import org.springframework.boot.test.context.SpringBootTest


@SpringBootTest
class BranchServiceTest {

    @Mock
    lateinit var branchRepository: BranchRepository

    @Mock
    lateinit var scheduleRepository: ScheduleRepository

    @InjectMocks
    lateinit var branchService: BranchService

    @Test
    fun `Get a list of all branches`() {
        `when`(branchRepository.findAll()).thenReturn(mockBranchesEntity)
        var result = branchService.getAllBranch()
        verify(branchRepository, times(1)).findAll()
        assertEquals(mockBranchesDTO, result)
    }

    /*@Test
    fun `Get available slots for a branch`() {

        val branchId:Long = 1
        `when`(branchRepository.findByIdOrNull(branchId)).thenReturn(mockBranchEntity)
        var result = branchService.getSlots(branchId)

        verify(branchRepository, times(1)).findByIdOrNull(branchId)
        assertEquals(mockSlotDT, result)
    }*/
}