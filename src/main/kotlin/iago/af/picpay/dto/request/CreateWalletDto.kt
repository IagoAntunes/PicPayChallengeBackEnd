package iago.af.picpay.dto.request

import iago.af.picpay.entity.WalletEntity
import iago.af.picpay.entity.WalletTypeEnum

data class CreateWalletDto(
    val fullName:String,
    val cpfCnpj:String,
    val email:String,
    val password:String,
    val walletType: WalletTypeEnum,
){
    fun toWallet(): WalletEntity {
        return WalletEntity(
            fullName = fullName,
            cpfCnpj = cpfCnpj,
            email = email,
            password = password,
            walletType = walletType.get()
        )
    }
}