package com.example.transactionfactory.service

class ApiClientResponse {

    private var code = 0
    private var message: String

    constructor(code: Int, message: String) {
        this.code = code
        this.message = message
    }

    fun message(): String {
        return message
    }

    fun code(): Int {
        return this.code
    }
}