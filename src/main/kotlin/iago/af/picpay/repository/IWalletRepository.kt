package iago.af.picpay.repository

import iago.af.picpay.entity.WalletEntity
import org.springframework.data.jpa.repository.JpaRepository
import java.util.Optional

interface IWalletRepository : JpaRepository<WalletEntity,Long>{
    fun findByCpfCnpjOrEmail(cpfCnpj: String, email: String): Optional<WalletEntity>
}