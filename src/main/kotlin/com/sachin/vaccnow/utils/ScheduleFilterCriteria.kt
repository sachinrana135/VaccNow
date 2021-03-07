package com.sachin.vaccnow.utils

import com.sachin.vaccnow.DATE_FORMAT
import com.sachin.vaccnow.entity.Branch
import com.sachin.vaccnow.entity.Schedule
import org.springframework.data.jpa.domain.Specification
import java.sql.Timestamp

class ScheduleFilterCriteria {

    companion object {
        fun statusIs(status: String?): Specification<Schedule>? = status?.let {
            Specification { root, _, cb ->
                cb.equal(root.get<String>("status"), status)
            }
        }

        fun fromBranch(branchId: Long?): Specification<Schedule>? = branchId?.let {
            Specification { root, _, cb ->
                cb.equal(root.get<Branch>("branch").get<Long>("id"), branchId)
            }
        }

        fun fromDate(fromDate: String?): Specification<Schedule>? = fromDate?.let {
            Specification { root, _, cb ->
                cb.greaterThanOrEqualTo(root.get<Timestamp>("dateCreated"), fromDate.toTimeStamp(DATE_FORMAT))
            }
        }

        fun toDate(toDate: String?): Specification<Schedule>? = toDate?.let {
            Specification { root, _, cb ->
                var toDate = Timestamp.valueOf(toDate.toTimeStamp(DATE_FORMAT).toLocalDateTime().plusHours(23).plusMinutes(59).plusSeconds(59))
                cb.lessThanOrEqualTo(root.get<Timestamp>("dateModified"), toDate)
            }
        }
    }
}
