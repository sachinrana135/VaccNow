package com.sachin.VaccNow.error

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(HttpStatus.CONFLICT)
class DuplicateRecordFoundException() : RuntimeException() {

}