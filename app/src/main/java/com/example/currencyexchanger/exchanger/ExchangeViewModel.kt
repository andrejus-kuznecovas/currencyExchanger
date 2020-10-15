package com.example.currencyexchanger.exchanger

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.currencyexchanger.data.CurrencyRepository
import com.example.currencyexchanger.model.Balance
import kotlinx.coroutines.launch

class ExchangeViewModel(private val defaultCurrencyRepository: CurrencyRepository) : ViewModel() {

    private val _balances = MutableLiveData<List<Balance>>()
    val balances: LiveData<List<Balance>> = _balances

    private val _rates = MutableLiveData<Set<String>>(setOf("NaN"))
    val rates = _rates

    init {
        loadBalances()
        loadCurrencyRates()
    }

    private fun loadBalances() {
        viewModelScope.launch {
            _balances.value = defaultCurrencyRepository.getBalances()
        }
    }

    private fun loadCurrencyRates() {
        viewModelScope.launch {
            _rates.value = defaultCurrencyRepository.getRates().rate.keys
        }
    }
}