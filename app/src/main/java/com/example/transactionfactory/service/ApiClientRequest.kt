package com.example.transactionfactory.service

class ApiClientRequest {
    private var originAccount = 0
    private var originBank: String
    private var originAmount = 0
    private var destinyAccount = 0
    private var destinyBank: String
    private var destinyAmount = 0

    constructor(origin: Operation, destiny: Operation) {
        originAccount = origin.account()
        originBank = origin.bank()
        originAmount = origin.amount()
        destinyAccount = destiny.account()
        destinyBank = destiny.bank()
        destinyAmount = destiny.amount()
    }

    fun originBank(): String {
        return originBank
    }
}