package com.example.myapplication.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.adapter.SellAdapter
import com.example.myapplication.viewModel.SellViewModel

class SellFragment : Fragment() {
    private lateinit var viewModel: SellViewModel
    private var sellAdapter = SellAdapter()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_sell, container, false)
        val recyclerView: RecyclerView = view.findViewById(R.id.rvSell)
        recyclerView.adapter = sellAdapter

        viewModel = ViewModelProviders.of(this).get(SellViewModel::class.java)
        viewModel.getSellData().observe(viewLifecycleOwner, Observer {
            sellAdapter.setSellList(it)
        })
        return view
    }
}