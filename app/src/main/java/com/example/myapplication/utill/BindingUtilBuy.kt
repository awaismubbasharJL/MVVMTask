package com.example.myapplication.utill

import android.view.View
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.adapter.BuyAdapter
import com.example.myapplication.model.BuyModel

class BindingUtilBuy {
    companion object{
        @JvmStatic
        @BindingAdapter("buyAdapter")
        fun setBuyAdapter(view: View, list: List<BuyModel>?){
            val recyclerView = view as RecyclerView
            val adapter = recyclerView.adapter as BuyAdapter
            if (list != null) {
                adapter.setBuyList(list)
            }
        }
    }
}