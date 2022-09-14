package com.example.somefood.ui.historyOrderFragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.somefood.R
import com.example.somefood.data.model.OrderRating
import com.example.somefood.data.model.ProductListModel
import com.example.somefood.databinding.HistoryOrderItemBinding

class HistoryOrderAdapter: RecyclerView.Adapter<HistoryOrderAdapter.MyViewHolder>() {

    private val myList: MutableList<OrderRating> = mutableListOf()

    fun set(newList: List<OrderRating>) {
        this.myList.clear()
        this.myList.addAll(newList)
        notifyDataSetChanged()
    }

    class MyViewHolder(view: View): RecyclerView.ViewHolder(view) {
        private val binding = HistoryOrderItemBinding.bind(view)
        fun bind(orderItem: OrderRating) =
            with(binding){
                starForClient.rating = orderItem.starForClient?.toFloat() ?: 0.0F
                starForCreator.rating = orderItem.starForCreator?.toFloat() ?: 0.0F
                orderId.text = orderItem.orderId.toString()
            }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.history_order_item, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(myList[position])
    }

    override fun getItemCount(): Int = myList.size

}