package com.sachin.vaccnow.utils

import com.sachin.vaccnow.entity.Schedule
import com.sachin.vaccnow.utils.ScheduleFilterCriteria.Companion.fromBranch
import com.sachin.vaccnow.utils.ScheduleFilterCriteria.Companion.fromDate
import com.sachin.vaccnow.utils.ScheduleFilterCriteria.Companion.statusIs
import com.sachin.vaccnow.utils.ScheduleFilterCriteria.Companion.toDate
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