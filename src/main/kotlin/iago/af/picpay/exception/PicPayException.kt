package iago.af.picpay.exception

import org.springframework.http.HttpStatus
import org.springframework.http.ProblemDetail

open class PicPayException() : RuntimeException() {

     open fun toProblemDetail(): ProblemDetail{
         val pb = ProblemDetail.forStatus(HttpStatus.INTERNAL_SERVER_ERROR)
         pb.title = "PicPacy Internal server error"
         return pb
     }

 }