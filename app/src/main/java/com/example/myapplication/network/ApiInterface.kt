package com.example.myapplication.network

import com.example.myapplication.model.BuyModel
import com.example.myapplication.model.CallModel
import retrofit2.Response
import retrofit2.http.GET

interface ApiInterface {

    @GET("call")
    suspend fun getCallList() : Response<List<CallModel>>

    @GET("buy")
    suspend fun getBuyList() : Response<List<BuyModel>>
}