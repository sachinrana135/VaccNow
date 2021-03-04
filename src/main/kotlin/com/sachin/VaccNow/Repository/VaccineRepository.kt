package com.sachin.VaccNow.Repository

import com.sachin.VaccNow.Entity.Vaccine
import org.springframework.data.repository.CrudRepository

interface VaccineRepository : CrudRepository<Vaccine,Long>