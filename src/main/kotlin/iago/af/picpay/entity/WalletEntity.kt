package iago.af.picpay.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table
import java.math.BigDecimal


@Entity
@Table(name = "tb_wallet")
data class WalletEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id:Long,
    @Column(name = "full_name")
    val fullName:String,
    @Column(name = "cpfCnpj",unique = true)
    val cpfCnpj:String,
    @Column(name = "email",unique = true)
    val email:String,
    @Column(name = "password")
    val password:String,
    @Column(name = "balance")
    val balance:BigDecimal = BigDecimal.ZERO,

    @ManyToOne
    @JoinColumn(name = "wallet_type_id")
    val walletType: WalletType
){

    constructor(fullName: String, cpfCnpj: String, email: String, password: String, walletType: WalletType)
            : this(0, fullName, cpfCnpj, email, password, BigDecimal.ZERO, walletType)
}