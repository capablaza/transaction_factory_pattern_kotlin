package com.example.transactionfactory.service

import org.junit.Assert
import org.junit.Test

class TransferServiceTest {

    @Test
    fun shouldReturn200WhenOriginAndDestinyAreCorrects() {
        val storage: Storage = StorageDummy()
        val service = TransferService(storage)
        val opOrigin = Operation(10092, "santander", 50400)
        val opDestiny = Operation(98128, "bci", 90500)
        val response = service.transfer(opOrigin, opDestiny)
        Assert.assertEquals(200, response!!.code())
    }

    @Test
    fun shouldReturn501WhenOriginOrDestinyIsNotCorrect() {
        val storage: Storage = StorageDummy()
        val service = TransferService(storage)
        val opOrigin = Operation(10092, "bbva", 50400)
        val opDestiny = Operation(98128, "santader", 90500)
        val response = service.transfer(opOrigin, opDestiny)
        Assert.assertEquals(501, response!!.code())
    }
}