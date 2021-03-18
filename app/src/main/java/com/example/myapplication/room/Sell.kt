package com.example.myapplication.room

import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlin.properties.Delegates

@Entity
data class Sell(@PrimaryKey(autoGenerate = true)
                val id: Int,
                val name: String,
                val price: Double,
                val quantity: Int)

