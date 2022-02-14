package me.whale.spring.starter.web

import jakarta.validation.ValidationException
import org.slf4j.LoggerFactory
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus

/**
 * view import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler
 */
@ControllerAdvice
@ConditionalOnMissingBean(annotation = [ControllerAdvice::class])
@ConditionalOnClass(ControllerAdvice::class)
class GlobalExceptionHandler {
    // todo: add i18n support
    private val logger = LoggerFactory.getLogger(this.javaClass)

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(
        ValidationException::class
    )
    fun handleValidation(exception: java.lang.Exception): ResponseEntity<Any> {
        logger.error("request validation error ", exception)
        return ResponseEntity.ok("request validation error!")
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(
        Exception::class
    )
    fun handleGenericException(exception: java.lang.Exception): ResponseEntity<Any> {
        logger.error("bad request! ", exception)
        return ResponseEntity.ok("bad request!")
    }
}