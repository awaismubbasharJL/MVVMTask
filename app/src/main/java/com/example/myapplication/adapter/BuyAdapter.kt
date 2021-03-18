package com.example.myapplication.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.model.BuyModel
import com.example.myapplication.R

class BuyAdapter(): RecyclerView.Adapter<BuyAdapter.ViewHolder>() {
    private var buyList =  ArrayList<BuyModel>()

    fun setBuyList(buyList: List<BuyModel>){
        this.buyList.addAll(buyList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.buy_list, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.buyId.text = buyList.get(position).id.toString()
        holder.buyName.text = buyList.get(position).name.toString()
        holder.buyPrice.text = buyList.get(position).price.toString()
    }

    override fun getItemCount(): Int {
        return buyList.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val buyId: TextView = itemView.findViewById(R.id.buy_id)
        val buyName: TextView = itemView.findViewById(R.id.buy_name)
        val buyPrice: TextView = itemView.findViewById(R.id.buy_price)
    }
}