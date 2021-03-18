package com.example.myapplication.repository

import com.example.myapplication.model.CallModel
import com.example.myapplication.network.ApiInterface
import com.example.myapplication.network.Result
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory

const val CALL_BASE_URL= "https://my-json-server.typicode.com/imkhan334/demo-1/"
object CallRepository {
    lateinit var apiInterface: ApiInterface

    init {
        makeApiCall()
    }

    private fun makeApiCall(){
        val retrofit = Retrofit.Builder().baseUrl(CALL_BASE_URL).addConverterFactory(
            GsonConverterFactory.create()).build()

        this.apiInterface = retrofit.create(ApiInterface::class.java)
    }

    suspend fun getCallData(): Result<List<CallModel>>{
        return safeApiCall(call = { apiInterface.getCallList() })
    }

    suspend fun <T : Any> safeApiCall(call: suspend () -> Response<T>): Result<T> {
        return try {
            val myResp = call.invoke()
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