package com.rana.mymovieapplication.presentation.homescreen.recyclerview

import android.content.Context
import android.content.SharedPreferences
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.rana.mymovieapplication.BuildConfig
import com.rana.mymovieapplication.R
import com.rana.mymovieapplication.data.remote.entities.MoviesModel
import kotlinx.android.synthetic.main.nowplaying_rv_item.view.*

class NowPlayingAdapter(val movieItemCallBack: (movieId: Long) -> Unit) :
    RecyclerView.Adapter<NowPlayingAdapter.MyViewHolder>() {

    private var movies = emptyList<MoviesModel.Result>()


    class MyViewHolder(
        itemView: View, val movieItemCallBack:
            (movieId: Long) -> Unit
    ) : RecyclerView.ViewHolder(itemView) {

        fun bind(movie: MoviesModel.Result) {
            itemView.filmnameTV.text = movie.original_title

            itemView.rating_count_number_TV.text = movie.vote_count.toString()
            itemView.rating_average_number_TV.text = movie.vote_average.toString()
            itemView.card_background
                .load("${BuildConfig.PHOTO_BASE_URL}${movie.poster_path}")
            itemView.imageslider
                .load("${BuildConfig.PHOTO_BASE_URL}${movie.poster_path}")

            val preferences: SharedPreferences = itemView.context
                .getSharedPreferences("My Movie Application", Context.MODE_PRIVATE)
//            val desData =  preferences.getString("My Movie Application", String().desrialize())
            itemView.filmcategoryTV.text = preferences.toString()


            itemView.sliderCardView.setOnClickListener() {
                movieItemCallBack(movie.id.toLong())
            }


        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.nowplaying_rv_item,
            parent, false
        )
        return MyViewHolder(view, movieItemCallBack)

    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(movies[position])
    }

    override fun getItemCount(): Int {
        return movies.size
    }

    fun setData(movies: List<MoviesModel.Result>) {
        this.movies = movies
    }


}