package com.sachin.vaccnow.utils

import com.sachin.vaccnow.dto.BranchDTO
import com.sachin.vaccnow.dto.VaccineDTO
import com.sachin.vaccnow.entity.Branch
import com.sachin.vaccnow.entity.BranchVaccine

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
