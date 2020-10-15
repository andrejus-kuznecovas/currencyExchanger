package com.example.currencyexchanger.data.remote

import androidx.lifecycle.MutableLiveData
import com.example.currencyexchanger.data.CurrencyDataSource
import com.example.currencyexchanger.model.Balance
import com.example.currencyexchanger.model.CurrencyRates
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

class CurrencyRemoteDataSource(private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO) :
    CurrencyDataSource {
    private val _currencyRates = MutableLiveData<CurrencyRates>()
    val observableCurrencyRates = _currencyRates

    override suspend fun getBalances(): List<Balance> {
        return emptyList()
    }

    override suspend fun getRates(): CurrencyRates {
        //val allCurrencyRatesDeferred = Exchanger.retrofitService.getRatesAsync()
        return Exchanger.retrofitService.getRatesAsync().await()
    }

    suspend fun refreshRates() {
        _currencyRates.value = getRates()
    }

}