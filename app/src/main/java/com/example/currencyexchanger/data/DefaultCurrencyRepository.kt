package com.example.currencyexchanger.data

import com.example.currencyexchanger.model.Balance
import com.example.currencyexchanger.model.CurrencyRates
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

class DefaultCurrencyRepository(
    private val currencyLocalDataSource: CurrencyDataSource,
    private val currencyRemoteDataSource: CurrencyDataSource,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) : CurrencyRepository {
    override suspend fun getBalances(): List<Balance> {
        return currencyLocalDataSource.getBalances()
    }

    override suspend fun getRates(): CurrencyRates {
        return currencyRemoteDataSource.getRates()
    }
}
