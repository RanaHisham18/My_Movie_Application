package com.rana.mymovieapplication.presentation.moviedetails.recylerview

import com.rana.mymovieapplication.R
import kotlinx.android.synthetic.main.trailer_rv_item.view.*
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView


class MovieTrailerAdapter(val movieItemCallBack: (videoKey: String) -> Unit): RecyclerView.Adapter<MovieTrailerAdapter.MyViewHolder>() {
    private var trailerList = listOf<MovieTrailerModel.Result>()

    class MyViewHolder(itemView: View, val movieItemCallBack: (videoKey: String) -> Unit):
        RecyclerView.ViewHolder(itemView) {
        fun bindData(trailer: MovieTrailerModel.Result) {
            itemView.cvTrailer.setOnClickListener{
                movieItemCallBack(trailer.key)
            }
        }
    }

    fun setData(trailers: List<MovieTrailerModel.Result>) {
        trailerList = trailers
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.trailer_rv_item,
            parent,
            false
        )
        return MyViewHolder(view, movieItemCallBack)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bindData(trailerList[position])
    }

    override fun getItemCount(): Int {
        return trailerList.size
    }
}
