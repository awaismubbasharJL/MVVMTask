package com.example.myapplication.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.myapplication.repository.SellRepository
import com.example.myapplication.room.Sell
import com.example.myapplication.room.AppDatabase

class SellViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: SellRepository

    init {

        repository = SellRepository()
    }

    fun getSellData(): LiveData<List<Sell>>{
        return repository.getSell()
    }

    suspend fun insert(sell: Sell) {
        repository.insert(sell)
    }
}