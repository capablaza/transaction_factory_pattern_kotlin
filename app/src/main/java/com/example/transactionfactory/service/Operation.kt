package com.example.transactionfactory.service

class Operation {
    private var account = 0
    private var bank: String
    private var amount = 0

    constructor(account: Int, bank: String, amount: Int) {
        this.account = account
        this.bank = bank
        this.amount = amount
    }

    fun bank(): String {
        return bank
    }

    fun account(): Int {
        return account
    }

    fun amount(): Int {
        return amount
    }

}