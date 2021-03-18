package com.example.myapplication.utill

import android.view.View
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.adapter.CallAdapter
import com.example.myapplication.model.CallModel

class BindingUtilCall {
    companion object{
        @JvmStatic
        @BindingAdapter("callAdapter")
        fun setCallAdapter(view: View, list: List<CallModel>?){
            val recyclerView= view as RecyclerView
            if (recyclerView.adapter != null){
                val adapter = recyclerView.adapter as CallAdapter
                if (list != null) {
                    adapter.setCallList(list)
                }
            }
        }
    }
}