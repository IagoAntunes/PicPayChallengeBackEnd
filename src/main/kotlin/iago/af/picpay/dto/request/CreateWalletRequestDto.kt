package iago.af.picpay.dto.request

import iago.af.picpay.entity.WalletEntity
import iago.af.picpay.entity.WalletTypeEnum
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull


data class CreateWalletRequestDto(
    @field:NotBlank(message = "Full name is required")
    val fullName: String? = null,

    @field:NotBlank(message = "CPF/CNPJ is required")
    val cpfCnpj: String? = null,

    @field:NotBlank(message = "Email is required")
    val email: String? = null,

    @field:NotBlank(message = "Password is required")
    val password: String? = null,

    @field:NotNull(message = "Wallet type is required")
    val walletType: WalletTypeEnum? = null
) {
    fun toWallet(): WalletEntity {
        return WalletEntity(
            fullName = fullName!!,  // O operador !! assume que o campo já foi validado como não-nulo
            cpfCnpj = cpfCnpj!!,
            email = email!!,
            password = password!!,
            walletType = walletType!!.get()  // ou o que seja necessário no seu código
        )
    }
}
