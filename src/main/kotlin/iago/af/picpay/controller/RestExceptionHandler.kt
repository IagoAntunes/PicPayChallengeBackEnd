package iago.af.picpay.controller

import iago.af.picpay.exception.PicPayException
import org.springframework.http.HttpStatus
import org.springframework.http.ProblemDetail
import org.springframework.http.converter.HttpMessageNotReadableException
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class RestExceptionHandler {

    @ExceptionHandler(PicPayException::class)
    fun handlePicPayException(e:PicPayException): ProblemDetail {
        return e.toProblemDetail()
    }
    @ExceptionHandler(HttpMessageNotReadableException::class)
    fun handleHttpMessageNotReadableException(e: HttpMessageNotReadableException): ProblemDetail {
        val pb = ProblemDetail.forStatus(HttpStatus.BAD_REQUEST)
        pb.title = "Invalid request"
        pb.detail = e.message
        return pb
    }
    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun handleMethodArgumentNotValidException(e:MethodArgumentNotValidException): ProblemDetail {

        val fieldErrors = e.getFieldErrors()
            .stream()
            .map { error ->
                FieldError(
                    error.getField(),
                    error.getDefaultMessage()?:""
                )
            }.toList()

        val pb = ProblemDetail.forStatus(HttpStatus.BAD_REQUEST)
        pb.title = "Invalid request"
        pb.setProperty(
            "invalid-params",
            fieldErrors
        )

        return pb
    }

    data class FieldError(
        val name:String,
        val reason:String
    )


}