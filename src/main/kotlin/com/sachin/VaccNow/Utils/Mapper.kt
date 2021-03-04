package com.sachin.VaccNow.Utils

import com.sachin.VaccNow.DTO.BranchDTO
import com.sachin.VaccNow.DTO.VaccineDTO
import com.sachin.VaccNow.Entity.Branch
import com.sachin.VaccNow.Entity.BranchVaccine

fun branchEntityToDTOMapper(branch: Branch): BranchDTO {

    return BranchDTO(
            id = branch.id,
            name = branch.name,
            location = branch.location
    )
}

fun branchVaccineEntityToVaccineDTOMapper(entity: BranchVaccine): VaccineDTO {
    return VaccineDTO(
            id = entity.vaccine.id,
            name = entity.vaccine.name,
            cost = entity.vaccine.cost,
            quantity = entity.count
    )
}
