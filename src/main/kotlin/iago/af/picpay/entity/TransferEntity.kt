package iago.af.picpay.entity

import jakarta.persistence.*
import java.math.BigDecimal
import java.util.UUID

@Entity
@Table(name = "tb_transfer")
 class TransferEntity (

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    val id:UUID,

    @ManyToOne
    @JoinColumn(name = "wallet_sender_id")
    val sender:WalletEntity,

    @ManyToOne
    @JoinColumn(name = "wallet_receiver_id")
    val receiver:WalletEntity,

    @Column(name = "value")
    val value:BigDecimal

){

     constructor(sender: WalletEntity, receiver: WalletEntity, value: BigDecimal)
             : this(UUID.randomUUID(), sender, receiver, value)
 }