package com.rana.mymovieapplication.presentation.moviedetails

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rana.mymovieapplication.R
import com.rana.mymovieapplication.data.remote.entities.MovieTrailerModel


class MovieTrailerAdapter: RecyclerView.Adapter<MovieTrailerAdapter.MyViewHolder>() {

    private var movies = emptyList<MovieTrailerModel.Result>()
    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
     fun bind (movie: MovieTrailerModel.Result){
       //Todo
     }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.nowplaying_seeall_rv_item,
            parent, false)
        return MovieTrailerAdapter.MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return movies.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(movies.get(position))
    }

}