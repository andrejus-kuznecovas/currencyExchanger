package com.example.currencyexchanger.data.local

import io.realm.RealmObject

open class RealmCurrency(
    var rates: Map<String, Double> = emptyMap(),
    var base: String = ""
) : RealmObject() {

}