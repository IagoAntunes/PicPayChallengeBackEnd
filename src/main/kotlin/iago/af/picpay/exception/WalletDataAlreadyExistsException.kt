package iago.af.picpay.exception

import org.springframework.http.HttpStatus
import org.springframework.http.ProblemDetail

class WalletDataAlreadyExistsException(
    val detail:String
) : PicPayException() {

    override fun toProblemDetail(): ProblemDetail {
        val pb = ProblemDetail.forStatus(HttpStatus.UNPROCESSABLE_ENTITY)

        pb.title = "Wallet data already exists"
        pb.detail = detail

        return pb
    }


}