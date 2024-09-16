package iago.af.picpay.exception

import org.springframework.http.HttpStatus
import org.springframework.http.ProblemDetail

class WalletNotFoundException(
    val walletId:Long
) : PicPayException(){




    override fun toProblemDetail(): ProblemDetail {
       val pb = ProblemDetail.forStatus(HttpStatus.UNPROCESSABLE_ENTITY)

        pb.title = "Wallet not found"
        pb.detail = "Wallet not found$walletId"


        return pb


    }


}