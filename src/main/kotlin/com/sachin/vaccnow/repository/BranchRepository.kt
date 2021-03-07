package com.sachin.vaccnow.repository

import com.sachin.vaccnow.entity.Branch
import org.springframework.data.repository.CrudRepository

interface BranchRepository : CrudRepository<Branch,Long>