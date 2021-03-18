package com.example.myapplication

import android.app.Application
import android.content.Context
import com.example.myapplication.room.AppDatabase

class TestApplication : Application() {

    companion object{
        lateinit var context : Context
    }

    override fun onCreate() {
        super.onCreate()
        context = this
        AppDatabase.getInstance(this)
    }
}