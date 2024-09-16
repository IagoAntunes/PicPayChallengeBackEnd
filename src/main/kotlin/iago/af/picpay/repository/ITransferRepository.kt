package iago.af.picpay.repository

import iago.af.picpay.entity.TransferEntity
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface ITransferRepository : JpaRepository<TransferEntity,UUID> {
}