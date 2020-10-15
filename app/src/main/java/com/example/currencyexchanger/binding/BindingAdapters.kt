package com.example.currencyexchanger.binding

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.currencyexchanger.exchanger.BalanceAdapter
import com.example.currencyexchanger.model.Balance


@BindingAdapter("app:items")
fun setItems(listView: RecyclerView, items: List<Balance>?) {
    items.let {
        (listView.adapter as BalanceAdapter).submitList(items)
    }
}