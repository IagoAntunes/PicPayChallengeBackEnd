package iago.af.picpay.service

import iago.af.picpay.dto.request.TransferRequestDto
import iago.af.picpay.entity.TransferEntity
import iago.af.picpay.entity.WalletEntity
import iago.af.picpay.exception.InsufficientBalanceException
import iago.af.picpay.exception.TransferNotAllowedForWalletTypeException
import iago.af.picpay.exception.TransferNotAuthorizedException
import iago.af.picpay.exception.WalletNotFoundException
import iago.af.picpay.repository.ITransferRepository
import iago.af.picpay.repository.IWalletRepository
import jakarta.transaction.Transactional
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.concurrent.CompletableFuture

@Service
class TransferService {

    @Autowired
    lateinit var notificationService: NotificationService
    @Autowired
    lateinit var authorizationService: AuthorizationService
    @Autowired
    lateinit var transferRepository: ITransferRepository
    @Autowired
    lateinit var walletRepository: IWalletRepository

    @Transactional
    fun transfer(request: TransferRequestDto): TransferEntity {
        val senderWallet = walletRepository.findById(request.payer).orElseThrow{
            throw WalletNotFoundException(request.payer)
        }
        val receiverWallet = walletRepository.findById(request.payee).orElseThrow{
            throw WalletNotFoundException(request.payee)
        }

        validateTransfer(request,senderWallet)

        senderWallet.debit(request.value)
        receiverWallet.credit(request.value)

        val transfer = TransferEntity(senderWallet, receiverWallet, request.value)

        walletRepository.save(senderWallet)
        walletRepository.save(receiverWallet)
        val transferResult = transferRepository.save(transfer)

        CompletableFuture.runAsync({
            notificationService.sendNotification(transferResult)
        })


        return transferResult
    }

    private fun validateTransfer(request: TransferRequestDto, senderWallet: WalletEntity) {
        if(!senderWallet.isTransferAllowedForWalletType()){
            throw TransferNotAllowedForWalletTypeException()
        }

        if(!senderWallet.isEqualOrGreatherThen(request.value)){
            throw InsufficientBalanceException(request.value)
        }

        if(!authorizationService.isAuthorized(request)){
            throw TransferNotAuthorizedException()
        }
    }
}