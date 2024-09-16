package iago.af.picpay.service

import iago.af.picpay.client.AuthorizationClient
import iago.af.picpay.dto.request.TransferRequestDto
import iago.af.picpay.exception.PicPayException
import org.springframework.stereotype.Service

@Service
class AuthorizationService(
    val authorizationClient:AuthorizationClient
) {

    fun isAuthorized(transfer:TransferRequestDto) : Boolean{
        val response = authorizationClient.isAuthorized()
        if(response.statusCode.isError){
            throw PicPayException()
        }

        return response.body!!.authorized
    }


}