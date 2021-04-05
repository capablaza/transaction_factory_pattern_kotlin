package com.example.transactionfactory.service

import org.junit.Assert
import org.junit.Test

class TransferServiceTest {

    @Test
    fun shouldReturn200WhenOriginAndDestinyAreCorrects() {
        val storage: Storage = StorageDummy()
        val service = TransferService(storage)
        val opOrigin = Operation(10092, Bank.SANTANDER.name, 50400)
        val opDestiny = Operation(98128, Bank.BCI.name, 90500)
        val response = service.transfer(opOrigin, opDestiny)
        Assert.assertEquals(200, response.code().toLong())
    }

    @Test
    fun shouldReturn509WhenBankOriginIsNotFound() {
        val storage: Storage = StorageDummy()
        val service = TransferService(storage)
        val opOrigin = Operation(10092, "bbva", 50400)
        val opDestiny = Operation(98128, Bank.SANTANDER.name, 90500)
        val response = service.transfer(opOrigin, opDestiny)
        Assert.assertEquals(509, response.code().toLong())
    }
}