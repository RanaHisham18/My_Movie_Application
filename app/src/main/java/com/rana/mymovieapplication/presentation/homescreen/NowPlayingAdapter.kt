package com.rana.mymovieapplication.presentation.homescreen

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rana.mymovieapplication.R
import com.rana.mymovieapplication.data.remote.entities.NowPlayingModel.Result
import kotlinx.android.synthetic.main.nowplaying_rv_item.view.*

class NowPlayingAdapter : RecyclerView.Adapter<NowPlayingAdapter.MyViewHolder>() {

    private var movies = emptyList<Result>()

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(movie: Result) {
            itemView.filmnameTV.text = movie.original_title
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.nowplaying_rv_item,
            parent, false
        )
        return MyViewHolder(view)

    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
      holder.bind(movies.get(position))
    }

    override fun getItemCount(): Int {
        return movies.size
    }

    fun setData (movies: List<Result>){
        this.movies = movies
    }
}