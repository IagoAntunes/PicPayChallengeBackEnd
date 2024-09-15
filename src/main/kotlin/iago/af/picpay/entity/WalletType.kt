package iago.af.picpay.entity

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.Table

import jakarta.persistence.*

@Entity
@Table(name = "tb_wallet_type")
data class WalletType (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,
    val description: String
)

enum class WalletTypeEnum(val id: Long, val description: String) {
    USER(1, "user"),
    MERCHANT(2,"merchant");

    fun get(): WalletType{
        return WalletType(id, description)
    }
}