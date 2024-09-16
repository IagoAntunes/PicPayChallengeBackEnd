package iago.af.picpay.client

import iago.af.picpay.entity.TransferEntity
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody


@FeignClient(
    name = "notification",
    url = "\${client.notification-service.url}"
)
interface NotificationClient {

    @PostMapping
    fun sendNotification(@RequestBody transfer:TransferEntity):ResponseEntity<Unit>

}