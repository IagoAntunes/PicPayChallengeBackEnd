package iago.af.picpay.service

import iago.af.picpay.client.NotificationClient
import iago.af.picpay.entity.TransferEntity
import iago.af.picpay.exception.PicPayException
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import kotlin.math.log

@Service
class NotificationService(
    val notificationClient: NotificationClient,
) {
    val logger:Logger = LoggerFactory.getLogger(NotificationService::class.java)

    fun sendNotification(transfer:TransferEntity) : Unit{
       try {
           logger.info("Sending notification")
           val response = notificationClient.sendNotification(transfer)
           if(response.statusCode.isError){
               logger.error("Error sending notification")
               throw PicPayException()
           }
       }catch (e:Exception){
           logger.error("Error sending notification", e)
       }
    }

}