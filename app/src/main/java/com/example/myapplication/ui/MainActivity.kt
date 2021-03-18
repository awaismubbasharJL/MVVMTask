package com.example.myapplication.ui

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.fragment.BuyFragment
import com.example.myapplication.fragment.CallFragment
import com.example.myapplication.R
import com.example.myapplication.fragment.SellFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnCall: Button = findViewById(R.id.btnCall)
        val btnBuy: Button = findViewById(R.id.btnBuy)
        val btnSell: Button = findViewById(R.id.btnSell)

        btnCall.setOnClickListener(View.OnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.frameLayout, CallFragment::class.java, null)
                .commit()
        })

        btnBuy.setOnClickListener(View.OnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.frameLayout, BuyFragment::class.java, null)
                .commit()
        })

        btnSell.setOnClickListener(View.OnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.frameLayout, SellFragment::class.java, null)
                .commit()
        })
    }
}