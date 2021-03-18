package com.example.myapplication.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil.inflate
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.myapplication.R
import com.example.myapplication.adapter.CallAdapter
import com.example.myapplication.databinding.FragmentCallBinding
import com.example.myapplication.viewModel.CallViewModel


class CallFragment : Fragment() {
    private lateinit var viewModel: CallViewModel
    private val callAdapter = CallAdapter()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {

        val binding: FragmentCallBinding = inflate(inflater, R.layout.fragment_call, container, false)

        viewModel = ViewModelProviders.of(this).get(CallViewModel::class.java)
        binding.viewModel = viewModel
        viewModel.getCallFromServer()
        binding.rvCalls.adapter = callAdapter

        Log.d("Call List Size",callAdapter.itemCount.toString())

        return binding.root
    }
}
