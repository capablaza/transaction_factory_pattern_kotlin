package com.example.transactionfactory.service

interface Client {
    fun verifyAccount(operation: Operation): Boolean

    fun send(request: ApiClientRequest): ApiClientResponse
}