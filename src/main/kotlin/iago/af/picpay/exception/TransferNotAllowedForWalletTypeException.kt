package iago.af.picpay.exception

import org.springframework.http.HttpStatus
import org.springframework.http.ProblemDetail

class TransferNotAllowedForWalletTypeException : PicPayException() {

    override fun toProblemDetail(): ProblemDetail {
        val pb = ProblemDetail.forStatus(HttpStatus.UNPROCESSABLE_ENTITY)

        pb.title = "Transfer not allowed for wallet type"
        pb.detail = "The wallet type does not allow transfers"

        return pb
    }
}