package com.example.myapplication.viewModel

import android.app.Application
import androidx.databinding.ObservableField
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.example.myapplication.model.CallModel
import com.example.myapplication.network.Result
import com.example.myapplication.repository.CallRepository
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class CallViewModel(application: Application) : AndroidViewModel(application){

    val call: ObservableField<List<CallModel>> by lazy {
        ObservableField<List<CallModel>>()
    }

    val errorMessage: ObservableField<String> by lazy{
        ObservableField<String>()
    }

    fun getCallFromServer() {
        GlobalScope.launch {
            val retrofitCall = CallRepository.getCallData()
            when (retrofitCall) {
                is Result.Success -> {
                    call.set(retrofitCall.data)
                }
                is Result.Error -> {
                    errorMessage.set(retrofitCall.exception)
                }
            }
        }
    }
}
