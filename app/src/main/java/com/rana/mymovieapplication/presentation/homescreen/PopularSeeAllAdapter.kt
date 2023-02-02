package com.rana.mymovieapplication.presentation.homescreen

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.rana.mymovieapplication.R
import com.rana.mymovieapplication.data.remote.entities.PopularModel
import kotlinx.android.synthetic.main.popularseeall_rv_item.view.*

class PopularSeeAllAdapter: RecyclerView.Adapter<PopularSeeAllAdapter.MyViewHolder>() {


    private var movies = emptyList<PopularModel.Result>()

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        fun bind (movie : PopularModel.Result) {

            itemView.popularseeall_IV.load("https://image.tmdb.org/t/p/original/${movie.poster_path}")
            itemView.popualarseeall_filmname_TV.text = movie.original_title
            itemView.popualarseeall_ratingnumber_TV.text = movie.vote_count.toString()

        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.popularseeall_rv_item,
            parent, false)
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
