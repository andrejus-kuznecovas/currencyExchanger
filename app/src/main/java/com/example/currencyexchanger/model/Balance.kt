package com.example.currencyexchanger.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Balance(
    val amount: Double,
    val currency: String
) : Parcelable