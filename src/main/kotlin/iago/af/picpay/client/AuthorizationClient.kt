package iago.af.picpay.client

import iago.af.picpay.dto.AuthorizationResponse
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping

@FeignClient(
    name = "authorization",
    url = "\${client.authorization-service.url}"
)
interface AuthorizationClient {

    @GetMapping
    fun isAuthorized() : ResponseEntity<AuthorizationResponse>

}