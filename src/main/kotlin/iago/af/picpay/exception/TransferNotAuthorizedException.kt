package iago.af.picpay.exception

import org.springframework.http.HttpStatus
import org.springframework.http.ProblemDetail

class TransferNotAuthorizedException : PicPayException() {


    override fun toProblemDetail(): ProblemDetail {
        val pb = ProblemDetail.forStatus(
            HttpStatus.UNPROCESSABLE_ENTITY
        )

        pb.title = "Transfer Not Authorized"
        pb.detail = "The transfer was not authorized by the bank"

        return pb
    }

}