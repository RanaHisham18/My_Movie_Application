package com.rana.mymovieapplication.presentation.homescreen

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.rana.mymovieapplication.R
import com.rana.mymovieapplication.data.remote.entities.PopularModel
import com.rana.mymovieapplication.data.remote.entities.TopRatedModel
import kotlinx.android.synthetic.main.toprated_rv_item.view.*

class TopRatedAdapter(val movieItemCallBack: (movieId: Long) -> Unit)
    : RecyclerView.Adapter<TopRatedAdapter.MyViewHolder> () {

    private var movies = emptyList<TopRatedModel.Result>()
    class MyViewHolder (itemView: View, val movieItemCallBack: (movieId: Long) -> Unit)
        : RecyclerView.ViewHolder(itemView){
        fun bind(movie:TopRatedModel.Result){

            itemView.toprated_filmname_Tv.text = movie.original_title
            itemView.toprated_ratingnumber_count_TV.text = movie.vote_count.toString()
            itemView.toprated_ratingnumber_average_TV.text = movie.vote_average.toString()
            itemView.toprated_IV.load("https://image.tmdb.org/t/p/original/${movie.poster_path}")
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.toprated_rv_item,
            parent, false)
        return TopRatedAdapter.MyViewHolder(view, movieItemCallBack)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(movies.get(position))

    }

    override fun getItemCount(): Int {
      return movies.size
    }
    fun setData(movies: List<TopRatedModel.Result>) {
        this.movies = movies
    }
}