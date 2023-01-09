package com.rana.mymovieapplication.presentation.homescreen

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.rana.mymovieapplication.R
import com.rana.mymovieapplication.data.remote.entities.PopularModel
import com.rana.mymovieapplication.data.remote.entities.PopularModel.Result
import kotlinx.android.synthetic.main.nowplaying_rv_item.view.*
import kotlinx.android.synthetic.main.popular_rv_item.view.*

class PopularFilmsAdapter : RecyclerView.Adapter<PopularFilmsAdapter.MyViewHolder>() {
    private var movies = emptyList<PopularModel.Result>()

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(movie:PopularModel.Result){
            itemView.popularfilmname_Tv.text = movie.title
            itemView.popularfilmcategory_TV.text = movie.genre_ids.toString()
            itemView.rating_count_number_TV.text = movie.vote_count.toString()
            itemView.rating_average_number_TV.text = movie.vote_average.toString()
            itemView.imageslider.load("https://image.tmdb.org/t/p/original/${movie.poster_path}")


        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.popular_rv_item,
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

    fun setData(movies: List<PopularModel.Result>) {
        this.movies = movies
    }
}