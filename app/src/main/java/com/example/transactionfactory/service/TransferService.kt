package com.example.transactionfactory.service

class TransferService(val storage : Storage) {

    fun transfer(opOrigin: Operation, opDestiny: Operation): TransferResponse {
        val client = ApiClient()
        val originResponse: Boolean = client.verifyAccount(opOrigin)
        val destinyResponse: Boolean = client.verifyAccount(opDestiny)
        if (originResponse && destinyResponse) {
            val clientRequest = ApiClientRequest(opOrigin, opDestiny)
            val responseApi: ApiClientResponse = client.send(clientRequest)
            storage.save(responseApi.message())
            return TransferResponse(responseApi.code(), responseApi.message())
        }
        return TransferResponse(501, "The accounts aren't corrects")
    }
}