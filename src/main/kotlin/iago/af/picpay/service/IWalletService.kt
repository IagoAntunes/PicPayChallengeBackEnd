package iago.af.picpay.service

import iago.af.picpay.dto.request.CreateWalletRequestDto
import iago.af.picpay.entity.WalletEntity

interface IWalletService {
    fun createWallet(request: CreateWalletRequestDto): WalletEntity
}