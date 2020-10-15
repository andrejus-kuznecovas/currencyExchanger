package com.example.currencyexchanger.exchanger

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.currencyexchanger.data.CurrencyRepository

@Suppress("UNCHECKED_CAST")
class ExchangeViewModelFactory(private val currencyRepository: CurrencyRepository) :
    ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T =
        ExchangeViewModel(currencyRepository) as T
}