package com.sachin.VaccNow.Service

import com.sachin.VaccNow.Repository.BranchVaccineRepository
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.springframework.boot.test.context.SpringBootTest


@SpringBootTest
class BranchVaccineServiceTest {

    @Mock
    lateinit var branchVaccineRepository: BranchVaccineRepository

    @InjectMocks
    lateinit var branchVaccineService: BranchVaccineService

    @Test
    fun `Get a list of all available vaccines per branch`() {
        `when`(branchVaccineRepository.findAll()).thenReturn(mockBranchVaccinesEntity)
        var result = branchVaccineService.getAllVaccinesPerBranch()
        verify(branchVaccineRepository, Mockito.times(1)).findAll()
        Assertions.assertEquals(mockBranchVaccinesDTO, result)
    }

    @Test
    fun `Get a specific availability by branch`() {
        `when`(branchVaccineRepository.findAll()).thenReturn(mockBranchVaccinesEntity)
        var result = branchVaccineService.getAllVaccinesPerBranch()
        verify(branchVaccineRepository, Mockito.times(1)).findAll()
        Assertions.assertEquals(mockBranchVaccinesDTO, result)
    }
}