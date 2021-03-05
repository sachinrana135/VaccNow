package com.sachin.VaccNow.Utils

import org.springframework.stereotype.Component
import java.sql.Timestamp

@Component
class DateTimeUtils {

    fun getCurrentTimeStamp(): Timestamp {
        return Timestamp(System.currentTimeMillis())
    }
}