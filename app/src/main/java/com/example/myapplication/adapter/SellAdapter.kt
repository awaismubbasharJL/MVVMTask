package com.example.myapplication.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.room.Sell

class SellAdapter: RecyclerView.Adapter<SellAdapter.ViewHolder>() {
    private var sellList =  ArrayList<Sell>()

    fun setSellList(sellList: List<Sell>){
        this.sellList.addAll(sellList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.sell_list, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.sellId.text = sellList.get(position).id.toString()
        holder.sellName.text = sellList.get(position).name
        holder.sellPrice.text = sellList.get(position).price.toString()
        holder.sellQuantity.text = sellList.get(position).quantity.toString()
    }

    override fun getItemCount(): Int {
        return this.sellList.size
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val sellId: TextView = itemView.findViewById(R.id.sell_id)
        val sellName: TextView = itemView.findViewById(R.id.sell_name)
        val sellPrice: TextView = itemView.findViewById(R.id.sell_price)
        val sellQuantity: TextView = itemView.findViewById(R.id.sell_quantity)
    }
}