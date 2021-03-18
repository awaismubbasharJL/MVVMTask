package com.example.myapplication.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface SellDao {

    @Insert
     fun insertSellData(sell: Sell)

    @Query("Select * from Sell")
    fun getSellData(): LiveData<List<Sell>>
}