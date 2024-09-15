package iago.af.picpay.service

import iago.af.picpay.dto.request.CreateWalletDto
import iago.af.picpay.entity.WalletEntity
import iago.af.picpay.exception.WalletDataAlreadyExistsException
import iago.af.picpay.repository.IWalletRepository
import org.springframework.stereotype.Service

@Service
class WalletService(
    val walletRepository:IWalletRepository
) : IWalletService{
    override fun createWallet(request: CreateWalletDto): WalletEntity {
        val walletEntity = request.toWallet()

        val walletWb = walletRepository.findByCpfCnpjOrEmail(request.cpfCnpj, request.email)
        if(walletWb.isPresent){
            throw WalletDataAlreadyExistsException("Cpf/Cnpj or email already exists")
        }

        val createdWallet =  walletRepository.save(walletEntity)
        return createdWallet
    }
}