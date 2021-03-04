package com.sachin.VaccNow.Utils

import java.sql.Timestamp
import java.text.SimpleDateFormat
import java.util.*


fun String.toTimeStamp(format: String = "yyyy-MM-dd hh:mm"): Timestamp {
    val dateFormat = SimpleDateFormat(format)
    val parsedDate: Date = dateFormat.parse(this)
    return Timestamp(parsedDate.time)

}