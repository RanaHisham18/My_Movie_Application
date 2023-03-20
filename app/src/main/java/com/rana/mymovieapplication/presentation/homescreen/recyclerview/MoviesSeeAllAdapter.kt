package com.rana.mymovieapplication.presentation.homescreen.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.rana.mymovieapplication.R
import com.rana.mymovieapplication.data.remote.entities.MoviesModel
import kotlinx.android.synthetic.main.nowplaying_seeall_rv_item.view.*

class MoviesSeeAllAdapter(val movieItemCallBack: (movieId: Long) -> Unit): RecyclerView.Adapter<MoviesSeeAllAdapter.MyViewHolder> (){

    private var movies = emptyList<MoviesModel.Result>()

    class MyViewHolder(itemView: View, val movieItemCallBack: (movieId: Long) -> Unit) : RecyclerView.ViewHolder(itemView){

        fun bind(movie: MoviesModel.Result) {
            itemView.nowplaying_seeall_filmname_TV.text = movie.original_title
            itemView.nowplaying_seeall_ratingnumber_TV.text = movie.vote_count.toString()
            itemView.nowplaying_seeall_IV.load("https://image.tmdb.org/t/p/original/${movie.poster_path}")

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.nowplaying_seeall_rv_item,
            parent, false)
        return MyViewHolder(view, movieItemCallBack)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(movies.get(position))

    }

    override fun getItemCount(): Int {
        return movies.size
    }

    fun setData(movies: List<MoviesModel.Result>) {
        this.movies = movies
    }

}