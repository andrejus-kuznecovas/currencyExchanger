package com.example.currencyexchanger

import android.content.Context
import com.example.currencyexchanger.data.CurrencyRepository
import com.example.currencyexchanger.data.DefaultCurrencyRepository
import com.example.currencyexchanger.data.local.CurrencyLocalDataSource
import com.example.currencyexchanger.data.remote.CurrencyRemoteDataSource

object ServiceLocator {

    var currencyRepository: CurrencyRepository? = null

    fun provideCurrencyRepository(context: Context): CurrencyRepository {
        synchronized(this) {
            return currencyRepository ?: createCurrencyRepository(context)
        }
    }

    private fun createCurrencyRepository(context: Context): CurrencyRepository {
        val newRepo =
            DefaultCurrencyRepository(CurrencyLocalDataSource(), CurrencyRemoteDataSource())
        currencyRepository = newRepo
        return newRepo
    }
}