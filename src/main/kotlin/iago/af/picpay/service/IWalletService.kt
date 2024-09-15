package iago.af.picpay.service

import iago.af.picpay.dto.request.CreateWalletDto
import iago.af.picpay.entity.WalletEntity

interface IWalletService {
    fun createWallet(request: CreateWalletDto): WalletEntity
}