package iago.af.picpay.controller

import iago.af.picpay.dto.request.CreateWalletRequestDto
import iago.af.picpay.entity.WalletEntity
import iago.af.picpay.service.IWalletService
import jakarta.validation.Valid
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping
class WalletController {

    @Autowired
    private  lateinit var walletService: IWalletService

    @PostMapping("/wallets")
    fun createWallet(
        @Valid @RequestBody request:CreateWalletRequestDto
    ) :ResponseEntity<WalletEntity>{
        val result = walletService.createWallet(request)

        return ResponseEntity.ok(result)
    }
}