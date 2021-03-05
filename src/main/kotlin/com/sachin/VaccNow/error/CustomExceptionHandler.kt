package com.sachin.VaccNow.error

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler
import java.time.LocalDateTime


@ControllerAdvice
class CustomExceptionHandler : ResponseEntityExceptionHandler() {

    @ExceptionHandler(RecordNotFoundException::class)
    fun RecordNotFound(ex: RecordNotFoundException, request: WebRequest?): ResponseEntity<ErrorResponse?>? {
        var errorResponse = ErrorResponse(
                status = HttpStatus.NOT_FOUND,
                message = "Record not found",
                detail = ex.message.toString(),
                timeStamp = LocalDateTime.now()
        )
        return ResponseEntity<ErrorResponse?>(errorResponse, HttpStatus.NOT_FOUND)
    }

    @ExceptionHandler(DuplicateRecordFoundException::class)
    fun RecordNotFound(ex: DuplicateRecordFoundException, request: WebRequest?): ResponseEntity<ErrorResponse?>? {
        var errorResponse = ErrorResponse(
                status = HttpStatus.CONFLICT,
                message = "Record already exist",
                detail = ex.message.toString(),
                timeStamp = LocalDateTime.now()
        )
        return ResponseEntity<ErrorResponse?>(errorResponse, HttpStatus.CONFLICT)
    }

    @ExceptionHandler(InvalidRequestException::class)
    fun badRequest(ex: RecordNotFoundException, request: WebRequest?): ResponseEntity<ErrorResponse?>? {
        var errorResponse = ErrorResponse(
                status = HttpStatus.BAD_REQUEST,
                message = "Bad Request",
                detail = ex.message.toString(),
                timeStamp = LocalDateTime.now()
        )
        return ResponseEntity<ErrorResponse?>(errorResponse, HttpStatus.NOT_FOUND)
    }

    @ExceptionHandler(Exception::class)
    fun handleAllExceptions(ex: Exception, request: WebRequest?): ResponseEntity<ErrorResponse?> {
        var errorResponse = ErrorResponse(
                status = HttpStatus.INTERNAL_SERVER_ERROR,
                message = "server error",
                detail = ex.message.toString(),
                timeStamp = LocalDateTime.now()
        )
        return ResponseEntity<ErrorResponse?>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR)
    }

}