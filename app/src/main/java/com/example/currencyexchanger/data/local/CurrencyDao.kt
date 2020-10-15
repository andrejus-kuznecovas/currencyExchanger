package com.example.currencyexchanger.data.local

import androidx.lifecycle.LiveData
import com.example.currencyexchanger.model.Balance

interface CurrencyDao {
    fun getBalances(): LiveData<List<Balance>>
}