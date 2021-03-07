package com.sachin.vaccnow.service

import com.sachin.vaccnow.dto.BranchVaccineDTO
import com.sachin.vaccnow.entity.Branch
import com.sachin.vaccnow.entity.BranchVaccine
import com.sachin.vaccnow.repository.BranchVaccineRepository
import com.sachin.vaccnow.service.Interface.IBranchVaccineService
import com.sachin.vaccnow.utils.branchVaccineEntityToVaccineDTOMapper
import com.sachin.vaccnow.error.RecordNotFoundException
import org.springframework.stereotype.Service

@Service
class BranchVaccineService(private val branchVaccineRepository: BranchVaccineRepository) : IBranchVaccineService {
    override fun getAllVaccinesPerBranch(): List<BranchVaccineDTO> {

        return branchVaccineRepository.findAll()
                .groupBy { it.branch }
                .map<Branch, List<BranchVaccine>, BranchVaccineDTO> { (key, value) ->
                    BranchVaccineDTO(
                            branchId = key.id,
                            name = key.name,
                            vaccines = value.map {
                                branchVaccineEntityToVaccineDTOMapper(it)
                            }
                    )
                }
    }

    override fun getAllVaccinesByBranchId(branchId: Long): BranchVaccineDTO {
        val result = branchVaccineRepository.findVaccinesByBranchId(branchId)
        return result.map {
            branchVaccineEntityToVaccineDTOMapper(it)
        }?.takeIf { it.isNotEmpty() }
                ?.let {
                    BranchVaccineDTO(
                            branchId = result.first().branch.id,
                            name = result.first().branch.name,
                            vaccines = it
                    )
                } ?: throw RecordNotFoundException()
    }

}