package iago.af.picpay.exception

import org.springframework.http.HttpStatus
import org.springframework.http.ProblemDetail
import java.math.BigDecimal

class InsufficientBalanceException(
    val value:BigDecimal
) : PicPayException() {

    override fun toProblemDetail(): ProblemDetail {
        val pb = ProblemDetail.forStatus(HttpStatus.UNPROCESSABLE_ENTITY)

        pb.title = "Insufficient Balance"
        pb.detail = "The wallet does not have enough balance to make the transfer"

        return pb
    }

}