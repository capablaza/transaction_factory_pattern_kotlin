package com.example.transactionfactory.service

class ClientFactory {
    @Throws(ClientError::class)
    fun build(bank: String): Client {
        return when (Bank.valueOf(bank)) {
            Bank.SANTANDER -> SantanderClient()
            Bank.BCI -> BCIClient()
            else -> throw ClientError()
        }
    }
}