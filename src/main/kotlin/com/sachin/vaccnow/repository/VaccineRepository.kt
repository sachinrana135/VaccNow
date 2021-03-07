package com.sachin.vaccnow.repository

import com.sachin.vaccnow.entity.Vaccine
import org.springframework.data.repository.CrudRepository

interface VaccineRepository : CrudRepository<Vaccine,Long>