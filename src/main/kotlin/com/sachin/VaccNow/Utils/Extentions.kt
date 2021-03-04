package com.sachin.VaccNow.Utils

import java.sql.Timestamp
import java.text.SimpleDateFormat
import java.util.*


fun String.toTimeStamp(): Timestamp {

    val dateFormat = SimpleDateFormat("yyyy-MM-dd hh:mm")
    val parsedDate: Date = dateFormat.parse(this)
    return Timestamp(parsedDate.time)

}