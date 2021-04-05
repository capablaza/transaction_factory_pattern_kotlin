package com.example.transactionfactory.service

class BCIClient : Client {
    override fun verifyAccount(operation: Operation): Boolean {
        return operation.bank() == Bank.BCI.name
    }

    override fun send(request: ApiClientRequest): ApiClientResponse {
        return if (request.originBank() == Bank.BCI.name) {
            ApiClientResponse(200, "Ok from bci")
        } else ApiClientResponse(500, "Bank not valid")
    }
}