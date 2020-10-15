package com.example.currencyexchanger.data.local

import com.example.currencyexchanger.data.CurrencyDataSource
import com.example.currencyexchanger.model.Balance
import com.example.currencyexchanger.model.CurrencyRates
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

class CurrencyLocalDataSource internal constructor(
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) : CurrencyDataSource {
    private val tempList: List<Balance> = listOf(
        Balance(1000.0, "USD"),
        Balance(45.0, "EUR"),
        Balance(45.0, "EUR2"),
        Balance(45.0, "EUR3"),
        Balance(45.0, "EUR4"),
        Balance(45.0, "EUR5"),
        Balance(45.0, "EUR6"),
    )

    override suspend fun getBalances(): List<Balance> {
        return tempList
    }

    override suspend fun getRates(): CurrencyRates {
        val map = mutableMapOf<String, Double>()
        map["USD"] = 45.0
        return CurrencyRates(map, "USDXD")
    }
}