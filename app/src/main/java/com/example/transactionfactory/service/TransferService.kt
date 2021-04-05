package com.example.transactionfactory.service

class TransferService(val storage: Storage) {

    fun transfer(opOrigin: Operation, opDestiny: Operation): TransferResponse {
        val clientOrigin: Client = SantanderClient()
        val clientDestiny: Client = BCIClient()

        val originResponse = clientOrigin.verifyAccount(opOrigin)
        val destinyResponse = clientDestiny.verifyAccount(opDestiny)

        if (originResponse && destinyResponse) {
            val clientRequest = ApiClientRequest(opOrigin, opDestiny)
            val responseApi = clientOrigin.send(clientRequest)
            storage.save(responseApi.message())
            return TransferResponse(responseApi.code(), responseApi.message())
        }
        return TransferResponse(501, "The accounts aren't corrects")
    }
}