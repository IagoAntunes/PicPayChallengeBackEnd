package iago.af.picpay.config

import iago.af.picpay.entity.WalletTypeEnum
import iago.af.picpay.repository.IWalletTypeRepository
import org.springframework.boot.CommandLineRunner
import org.springframework.context.annotation.Configuration

@Configuration
class DataLoader(
    val walletTypeRepository: IWalletTypeRepository,
) : CommandLineRunner{
    override fun run(vararg args: String?) {
        WalletTypeEnum.entries.forEach {
            walletTypeRepository.save(it.get())
        }
    }
}