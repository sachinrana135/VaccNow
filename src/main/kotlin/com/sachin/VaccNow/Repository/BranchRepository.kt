package com.sachin.VaccNow.Repository

import com.sachin.VaccNow.Entity.Branch
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

interface BranchRepository : CrudRepository<Branch,Long>