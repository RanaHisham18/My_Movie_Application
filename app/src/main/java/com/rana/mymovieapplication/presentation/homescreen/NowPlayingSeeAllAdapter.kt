package com.rana.mymovieapplication.presentation.homescreen

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.rana.mymovieapplication.R
import com.rana.mymovieapplication.data.remote.entities.NowPlayingModel
import kotlinx.android.synthetic.main.nowplaying_rv_item.view.*
import kotlinx.android.synthetic.main.nowplaying_seeall_rv_item.view.*

class NowPlayingSeeAllAdapter: RecyclerView.Adapter<NowPlayingSeeAllAdapter.MyViewHolder> (){

    private var movies = emptyList<NowPlayingModel.Result>()

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        fun bind(movie: NowPlayingModel.Result) {
            itemView.nowplaying_seeall_filmname_TV.text = movie.original_title
            itemView.nowplaying_seeall_ratingnumber_TV.text = movie.vote_count.toString()
            itemView.nowplaying_seeall_IV.load("https://image.tmdb.org/t/p/original/${movie.poster_path}")

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.nowplaying_seeall_rv_item,
            parent, false)
        return NowPlayingSeeAllAdapter.MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(movies.get(position))

    }

    override fun getItemCount(): Int {
        return movies.size
    }

}