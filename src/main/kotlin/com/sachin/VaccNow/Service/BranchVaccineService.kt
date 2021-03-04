package com.sachin.VaccNow.Service

import com.sachin.VaccNow.DTO.BranchVaccineDTO
import com.sachin.VaccNow.Entity.Branch
import com.sachin.VaccNow.Entity.BranchVaccine
import com.sachin.VaccNow.Repository.BranchVaccineRepository
import com.sachin.VaccNow.Service.Interface.IBranchVaccineService
import com.sachin.VaccNow.Utils.branchVaccineEntityToVaccineDTOMapper
import com.sachin.VaccNow.error.RecordNotFoundException
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