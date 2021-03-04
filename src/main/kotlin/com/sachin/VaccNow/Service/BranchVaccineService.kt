package com.sachin.VaccNow.Service

import com.sachin.VaccNow.DTO.BranchVaccineDTO
import com.sachin.VaccNow.DTO.BranchVaccinesDTO
import com.sachin.VaccNow.Utils.branchVaccineEntityToVaccineDTOMapper
import com.sachin.VaccNow.Repository.BranchVaccineRepository
import com.sachin.VaccNow.Service.Interface.IBranchVaccineService
import org.springframework.stereotype.Service

@Service
class BranchVaccineService(private val branchVaccineRepository: BranchVaccineRepository) : IBranchVaccineService {
    override fun getAllVaccinesPerBranch(): BranchVaccinesDTO {
        var list = branchVaccineRepository.findAll()
                .groupBy { it.branch }
                .map { (key, value) ->
                    BranchVaccineDTO(
                            branchId = key.id,
                            name = key.name,
                            vaccines = value.map {
                                branchVaccineEntityToVaccineDTOMapper(it)
                            }
                    )
                }

        return BranchVaccinesDTO(list)
    }

    override fun getAllVaccinesByBranchId(branchId: Long): BranchVaccineDTO {
        val result = branchVaccineRepository.findAllVaccinesByBranchId(branchId)
        return result.map {
            branchVaccineEntityToVaccineDTOMapper(it)
        }?.takeIf { it.isNotEmpty() }
                ?.let {
                    BranchVaccineDTO(
                            branchId = result.first().branch.id,
                            name = result.first().branch.name,
                            vaccines = it
                    )
                } ?: throw Exception("not found")
    }

}