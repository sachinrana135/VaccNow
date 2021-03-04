package com.sachin.VaccNow.Utils

import com.sachin.VaccNow.Entity.Schedule
import com.sachin.VaccNow.Utils.ScheduleFilterCriteria.Companion.fromBranch
import com.sachin.VaccNow.Utils.ScheduleFilterCriteria.Companion.fromDate
import com.sachin.VaccNow.Utils.ScheduleFilterCriteria.Companion.statusIs
import com.sachin.VaccNow.Utils.ScheduleFilterCriteria.Companion.toDate
import org.springframework.data.jpa.domain.Specification

data class ScheduleFilter(
        var status: String? = null,
        var branchId: Long? = null,
        var from: String? = null,
        var `to`: String? = null


) {
    fun buildFilterSpecification(): Specification<Schedule> {
        return Specification.where(statusIs(status))
                .and(fromBranch(branchId))
                .and(fromDate(from))
                .and(toDate(`to`))
    }
}