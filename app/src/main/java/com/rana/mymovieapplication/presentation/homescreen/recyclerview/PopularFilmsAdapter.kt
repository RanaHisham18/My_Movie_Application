package com.rana.mymovieapplication.presentation.homescreen.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.rana.mymovieapplication.R
import kotlinx.android.synthetic.main.popular_rv_item.view.*

class PopularFilmsAdapter(val movieItemCallBack: (movieId: Long) -> Unit) :
    RecyclerView.Adapter<PopularFilmsAdapter.MyViewHolder>() {
    private var movies = emptyList<PopularModel.Result>()

    class MyViewHolder(
        itemView: View, val movieItemCallBack
        : (movieId: Long) -> Unit
    ) : RecyclerView.ViewHolder(itemView) {
        fun bind(movie: PopularModel.Result) {
            itemView.popularfilmname_Tv.text = movie.title
            itemView.popularfilmcategory_TV.text = movie.genre_ids.toString()
            itemView.ratingnumber_count_TV.text = movie.vote_count.toString()
            itemView.ratingnumber_average_TV.text = movie.vote_average.toString()
            itemView.popular_IV.load("https://image.tmdb.org/t/p/original/${movie.poster_path}")

            itemView.popular_card.setOnClickListener() {
                movieItemCallBack(movie.id.toLong())
            }

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.popular_rv_item,
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

    fun setData(movies: List<PopularModel.Result>) {
        this.movies = movies
    }
}