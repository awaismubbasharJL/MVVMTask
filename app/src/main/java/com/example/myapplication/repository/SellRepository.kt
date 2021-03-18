package com.example.myapplication.repository

import android.os.AsyncTask
import androidx.lifecycle.LiveData
import com.example.myapplication.TestApplication
import com.example.myapplication.room.AppDatabase
import com.example.myapplication.room.Sell
import com.example.myapplication.room.SellDao

class SellRepository{

    val appDatabase: AppDatabase = AppDatabase.getInstance(TestApplication.context)

    fun getSell(): LiveData<List<Sell>>{
        return appDatabase.sellDao().getSellData()
    }

    fun insert(sell: Sell) {
        appDatabase.sellDao().insertSellData(sell)
    }

}