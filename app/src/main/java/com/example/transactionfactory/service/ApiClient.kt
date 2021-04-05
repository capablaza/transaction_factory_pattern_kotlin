package com.example.transactionfactory.service

class ApiClient {
    fun verifyAccount(operation: Operation): Boolean {
        if (operation.bank() == "santander") {
            return true
        } else if (operation.bank() == "bci") {
            return true
        }
        return false
    }

    fun send(request: ApiClientRequest): ApiClientResponse {
        return when (request.originBank()) {
            "santander" -> ApiClientResponse(200, "Ok from santander")
            "bci" -> ApiClientResponse(200, "Ok from bci")
            "bbva" -> ApiClientResponse(200, "Ok from bbva")
            else -> ApiClientResponse(500, "Bank not valid")
        }
    }
}