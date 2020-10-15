package com.example.currencyexchanger.exchanger

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import com.example.currencyexchanger.CurrencyExchangerApplication
import com.example.currencyexchanger.databinding.FragmentExchangerBinding
import io.realm.Realm

class ExchangeFragment : Fragment() {
    private lateinit var realm: Realm
    lateinit var viewModel: ExchangeViewModel
    lateinit var listAdapter: BalanceAdapter
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        realm = Realm.getDefaultInstance()
        val binding = FragmentExchangerBinding.inflate(inflater)
        binding.lifecycleOwner = this.viewLifecycleOwner
        viewModel = provideViewModel()
        listAdapter = BalanceAdapter(viewModel)
        binding.balanceRecyclerview.adapter = listAdapter
        binding.viewModel = viewModel


        viewModel.rates.observe(viewLifecycleOwner, {
            val arrayAdapter: ArrayAdapter<String> =
                ArrayAdapter<String>(
                    requireContext(),
                    android.R.layout.simple_spinner_dropdown_item,
                    viewModel.rates.value!!.toTypedArray()
                )
            arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            binding.currencySpinnerReceive.adapter = arrayAdapter
            binding.currencySpinnerSell.adapter = arrayAdapter
        })
        setHasOptionsMenu(true)
        return binding.root
    }

    private fun provideViewModel() =
        ExchangeViewModelFactory((requireContext().applicationContext as CurrencyExchangerApplication).currencyRepository).create(
            ExchangeViewModel::class.java
        )

    override fun onDestroy() {
        super.onDestroy()
        realm.close()
    }
}