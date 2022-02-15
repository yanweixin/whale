package me.whale.spring.starter.web

import jakarta.validation.ValidationException
import org.slf4j.LoggerFactory
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice

/**
 * view import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler
 */
@RestControllerAdvice
@ConditionalOnMissingBean(annotation = [ControllerAdvice::class, RestControllerAdvice::class])
@ConditionalOnWebApplication
class GlobalRestExceptionHandler {
    // todo: add i18n support
    private val logger = LoggerFactory.getLogger(this.javaClass)

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(
        ValidationException::class
    )
    fun handleValidation(exception: java.lang.Exception): ResponseEntity<Any> {
        logger.error("request validation error ", exception)
        return ResponseEntity.badRequest().body("request validation error!");
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(
        Exception::class
    )
    fun handleGenericException(exception: java.lang.Exception): ResponseEntity<Any> {
        logger.error("system internal error! ", exception)
        return ResponseEntity.internalServerError().body("system internal error!")
    }
}