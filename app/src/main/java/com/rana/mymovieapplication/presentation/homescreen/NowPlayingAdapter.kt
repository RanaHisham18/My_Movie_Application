package com.rana.mymovieapplication.presentation.homescreen

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.rana.mymovieapplication.R
import com.rana.mymovieapplication.data.remote.entities.NowPlayingModel
import com.rana.mymovieapplication.data.remote.entities.NowPlayingModel.Result
import kotlinx.android.synthetic.main.nowplaying_rv_item.view.*

class NowPlayingAdapter : RecyclerView.Adapter<NowPlayingAdapter.MyViewHolder>() {

    private var movies = emptyList<NowPlayingModel.Result>()


    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(movie: NowPlayingModel.Result) {
            itemView.filmnameTV.text = movie.original_title
            itemView.filmcategoryTV.text = movie.genre_ids.toString()
            itemView.rating_count_number_TV.text = movie.vote_count.toString()
            itemView.rating_average_number_TV.text = movie.vote_average.toString()
            itemView.card_background.load("https://image.tmdb.org/t/p/original/${movie.poster_path}")
            itemView.imageslider.load("https://image.tmdb.org/t/p/original/${movie.poster_path}")

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

    fun setData (movies: List<NowPlayingModel.Result>){
        this.movies = movies
    }
}