package com.example.currencyexchanger

import android.app.Application
import com.example.currencyexchanger.data.CurrencyRepository
import io.realm.Realm

class CurrencyExchangerApplication : Application() {
    val currencyRepository: CurrencyRepository
        get() = ServiceLocator.provideCurrencyRepository(this)

    override fun onCreate() {
        super.onCreate()
        Realm.init(this)
    }


}