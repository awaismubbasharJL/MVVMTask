package com.example.myapplication.repository

import com.example.myapplication.model.BuyModel
import com.example.myapplication.network.ApiInterface
import com.example.myapplication.network.Result
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory

const val BUY_BASE_URL : String = "https://my-json-server.typicode.com/imkhan334/demo-1/"
object BuyRepository {
    lateinit var apiInterface: ApiInterface

    init {
        makeApiCall()
    }

    private fun makeApiCall() {

        val retrofit = Retrofit.Builder().baseUrl(BUY_BASE_URL).addConverterFactory(
            GsonConverterFactory.create()).build()

        this.apiInterface = retrofit.create(ApiInterface::class.java)
    }

    suspend fun getBuyData(): Result<List<BuyModel>> {
        return safeApiCall(buy = { apiInterface.getBuyList() })
    }

    suspend fun <T : Any> safeApiCall(buy: suspend () -> Response<T>): Result<T> {
        return try {
            val myResp = buy.invoke()
            if (myResp.isSuccessful) {
                Result.Success(myResp.body()!!)
            } else {
                Result.Error(myResp.errorBody()?.string() ?: "Something goes wrong")
            }
        } catch (e: Exception) {
            Result.Error(e.message ?: "Internet error runs")
        }
    }
}