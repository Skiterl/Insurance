package ru.skitel.insurance.exception.handlers

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import ru.skitel.insurance.exception.ResourceNotFoundException
import ru.skitel.insurance.utils.mapper.ApplicationError

@ControllerAdvice
class GlobalExceptionHandler {

    @ExceptionHandler
    fun catchResourceNotFoundException(exception: ResourceNotFoundException):ResponseEntity<ApplicationError>{
        return ResponseEntity(ApplicationError(HttpStatus.NOT_FOUND.value(), exception.message), HttpStatus.NOT_FOUND)
    }
}