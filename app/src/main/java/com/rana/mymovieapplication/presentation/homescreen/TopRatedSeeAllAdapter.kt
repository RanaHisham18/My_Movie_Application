package com.rana.mymovieapplication.presentation.homescreen

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.rana.mymovieapplication.R
import com.rana.mymovieapplication.data.remote.entities.TopRatedModel
import kotlinx.android.synthetic.main.toprated_seeall_rv_item.view.*

class TopRatedSeeAllAdapter : RecyclerView.Adapter<TopRatedSeeAllAdapter.MyViewHolder>() {

    private var movies = emptyList<TopRatedModel.Result>()

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(movie: TopRatedModel.Result) {
            itemView.toprated_seeall_filmname_TV.text = movie.original_title
            itemView.topratedseeall_ratingnumber_TV.text = movie.vote_count.toString()
            itemView.toprated_seeall_IV.load("https://image.tmdb.org/t/p/original/${movie.poster_path}")
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.toprated_seeall_rv_item,
            parent, false
        )
        return TopRatedSeeAllAdapter.MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(movies.get(position))
    }

    override fun getItemCount(): Int {
        return movies.size
    }
}
