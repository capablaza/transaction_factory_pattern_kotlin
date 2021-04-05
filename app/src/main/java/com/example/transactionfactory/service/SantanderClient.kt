package com.example.transactionfactory.service

class SantanderClient : Client{
    override fun verifyAccount(operation: Operation): Boolean {
        return operation.bank() == "santander"
    }

    override fun send(request: ApiClientRequest): ApiClientResponse {
        return if (request.originBank() == "santander") {
            ApiClientResponse(200, "Ok from santander")
        } else ApiClientResponse(500, "Bank not valid")
    }
}