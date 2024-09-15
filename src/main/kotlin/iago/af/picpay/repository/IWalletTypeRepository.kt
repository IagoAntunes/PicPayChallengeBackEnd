package iago.af.picpay.repository

import iago.af.picpay.entity.WalletType
import org.springframework.data.jpa.repository.JpaRepository

interface IWalletTypeRepository : JpaRepository<WalletType,Long> {
}