package iago.af.picpay.dto.request

import jakarta.validation.constraints.DecimalMin
import jakarta.validation.constraints.NotNull
import java.math.BigDecimal

data class TransferRequestDto(
    @field:DecimalMin("0.01")
    @field:NotNull
    val value:BigDecimal,
    @field:NotNull val payer:Long,
    @field:NotNull val payee: Long
)