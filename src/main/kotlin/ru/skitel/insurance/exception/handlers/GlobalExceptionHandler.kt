package ru.skitel.insurance.exception.handlers

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import ru.skitel.insurance.exception.ResourceAlreadyExistsException
import ru.skitel.insurance.exception.ResourceNotFoundException
import ru.skitel.insurance.exception.ApplicationError

@ControllerAdvice
class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException::class)
    fun catchResourceNotFoundException(exception: ResourceNotFoundException):ResponseEntity<ApplicationError>{
        val error = ApplicationError(HttpStatus.NOT_FOUND.value(), exception.message)
        return ResponseEntity(error, HttpStatus.NOT_FOUND)
    }

    @ExceptionHandler(ResourceAlreadyExistsException::class)
    fun catchResourceFoundException(exception: ResourceAlreadyExistsException):ResponseEntity<ApplicationError>{
        return ResponseEntity(ApplicationError(HttpStatus.BAD_REQUEST.value(), exception.message), HttpStatus.BAD_REQUEST)
    }
}