package com.example.currencyexchanger.data

import com.example.currencyexchanger.model.Balance
import com.example.currencyexchanger.model.CurrencyRates

interface CurrencyDataSource {

    suspend fun getBalances(): List<Balance>
    suspend fun getRates(): CurrencyRates
}