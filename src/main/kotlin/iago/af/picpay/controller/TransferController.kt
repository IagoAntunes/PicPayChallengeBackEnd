package iago.af.picpay.controller

import iago.af.picpay.dto.request.TransferRequestDto
import iago.af.picpay.entity.TransferEntity
import iago.af.picpay.service.TransferService
import jakarta.validation.Valid
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping
class TransferController {

    @Autowired
    lateinit var transferService: TransferService


    @PostMapping("/transfer")
    fun transfer(@RequestBody @Valid request: TransferRequestDto):ResponseEntity<TransferEntity>{
        val response = transferService.transfer(request)


        return ResponseEntity.ok(response)

    }




}