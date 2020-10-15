package com.example.currencyexchanger.model

import com.squareup.moshi.Json

data class CurrencyRates(
    @Json(name = "rates")
    val rate: Map<String, Double>,
    @Json(name = "base")
    val base: String
)