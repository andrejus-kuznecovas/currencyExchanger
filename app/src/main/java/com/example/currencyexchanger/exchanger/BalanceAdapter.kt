package com.example.currencyexchanger.exchanger

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.currencyexchanger.databinding.BalanceGridItemBinding
import com.example.currencyexchanger.model.Balance

class BalanceAdapter(private val viewModel: ExchangeViewModel) :
    ListAdapter<Balance, BalanceViewHolder>(DiffCallback) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BalanceViewHolder {
        return BalanceViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: BalanceViewHolder, position: Int) {
        val balance = getItem(position)
        holder.bind(viewModel, balance)
    }

    companion object DiffCallback : DiffUtil.ItemCallback<Balance?>() {
        override fun areItemsTheSame(oldItem: Balance, newItem: Balance): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: Balance, newItem: Balance): Boolean {
            return oldItem == newItem
        }
    }

    init {
        Log.i("BalanceAdapter", "Binding Init")
    }
}


class BalanceViewHolder(private var binding: BalanceGridItemBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(viewModel: ExchangeViewModel, balance: Balance?) {
        binding.viewModel = viewModel
        binding.balance = balance
        binding.executePendingBindings()
    }

    companion object {
        fun from(parent: ViewGroup): BalanceViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val binding = BalanceGridItemBinding.inflate(layoutInflater, parent, false)

            return BalanceViewHolder(binding)
        }
    }
}