package com.example.transactionfactory.service

class TransferService(val storage: Storage) {

    fun transfer(opOrigin: Operation, opDestiny: Operation): TransferResponse {
        return try {

            val client = ClientFactory()

            val clientOrigin: Client = client.build(opOrigin.bank())
            val clientDestiny: Client = client.build(opDestiny.bank())

            val originResponse = clientOrigin.verifyAccount(opOrigin)
            val destinyResponse = clientDestiny.verifyAccount(opDestiny)

            if (originResponse && destinyResponse) {
                val clientRequest = ApiClientRequest(opOrigin, opDestiny)
                val responseApi = clientOrigin.send(clientRequest)
                storage.save(responseApi.message())
                return TransferResponse(responseApi.code(), responseApi.message())
            }
            TransferResponse(501, "The accounts aren't corrects")
        } catch (ex: Exception) {
            TransferResponse(509, "Bank not found")
        }
    }
}