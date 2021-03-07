package com.sachin.vaccnow.error

import org.springframework.http.HttpStatus
import java.time.LocalDateTime

data class ErrorResponse(
        var status: HttpStatus,
        var message: String,
        var detail: String,
        var timeStamp: LocalDateTime
)