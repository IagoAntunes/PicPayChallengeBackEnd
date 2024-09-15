package iago.af.picpay.controller

import iago.af.picpay.exception.PicPayException
import org.springframework.http.ProblemDetail
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class RestExceptionHandler {

    @ExceptionHandler(PicPayException::class)
    fun handlePicPayException(e:PicPayException): ProblemDetail {
        return e.toProblemDetail()
    }
}