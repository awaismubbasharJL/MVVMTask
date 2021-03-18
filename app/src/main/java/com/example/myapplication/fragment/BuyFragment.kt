package com.example.myapplication.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.View.inflate
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.adapter.BuyAdapter
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentBuyBinding
import com.example.myapplication.viewModel.BuyViewModel

class BuyFragment : Fragment() {
    private lateinit var buyViewModel: BuyViewModel
    private val buyAdapter = BuyAdapter()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentBuyBinding = DataBindingUtil.inflate( inflater, R.layout.fragment_buy, container, false)

        buyViewModel = ViewModelProviders.of(this).get(BuyViewModel::class.java)
        binding.viewmodel = buyViewModel
        buyViewModel.getBuyFromServer()
        binding.rvBuy.adapter = buyAdapter

        Log.d("Buy List Size",buyAdapter.itemCount.toString())

        return binding.root
    }
}