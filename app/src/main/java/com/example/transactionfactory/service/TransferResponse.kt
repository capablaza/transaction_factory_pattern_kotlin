package com.example.transactionfactory.service

class TransferResponse {
    private var code = 0
    private var message: String

    constructor(code: Int, message: String) {
        this.code = code
        this.message = message
    }

    fun code(): Int {
        return this.code
    }
}