package com.example.myapplication.viewModel

import android.app.Application
import androidx.databinding.ObservableField
import androidx.lifecycle.AndroidViewModel
import com.example.myapplication.model.BuyModel
import com.example.myapplication.network.Result
import com.example.myapplication.repository.BuyRepository
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class BuyViewModel(application: Application) : AndroidViewModel(application) {
    val buy: ObservableField<List<BuyModel>> by lazy {
        ObservableField<List<BuyModel>>()
    }
    val errorMessage: ObservableField<String> by lazy{
        ObservableField<String>()
    }

    fun getBuyFromServer(){
        GlobalScope.launch {
            val retrofitBuy  = BuyRepository.getBuyData()
            when(retrofitBuy){
                is Result.Success -> {
                    buy.set(retrofitBuy.data)
                }
                is Result.Error -> {
                    errorMessage.set(retrofitBuy.exception)
                }
            }
        }
    }
}