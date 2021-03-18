package com.example.myapplication.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.model.CallModel
import com.example.myapplication.R

class CallAdapter(): RecyclerView.Adapter<CallAdapter.ViewHolder>() {
    private var callList =  ArrayList<CallModel>()

    fun setCallList(callList: List<CallModel>){
        this.callList.addAll(callList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.call_list, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.callId.text = callList.get(position).id.toString()
        holder.callName.text = callList.get(position).name.toString()
        holder.callNumber.text = callList.get(position).number.toString()
    }

    override fun getItemCount(): Int {
        return this.callList.size
    }

     class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val callId: TextView = itemView.findViewById(R.id.callId)
        val callName: TextView = itemView.findViewById(R.id.callName)
        val callNumber: TextView = itemView.findViewById(R.id.callNumber)


    }
}