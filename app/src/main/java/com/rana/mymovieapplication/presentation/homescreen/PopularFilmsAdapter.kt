package com.rana.mymovieapplication.presentation.homescreen

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rana.mymovieapplication.R

class PopularFilmsAdapter: RecyclerView.Adapter<PopularFilmsAdapter.MyViewHolder> () {
    class MyViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView){}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.popular_rv_item,
            parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

    }

    override fun getItemCount(): Int {
       return 5
    }
}