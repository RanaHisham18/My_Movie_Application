package com.rana.mymovieapplication.presentation.reviewscreen

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.rana.mymovieapplication.R
import com.rana.mymovieapplication.data.remote.entities.MovieReviewsModel
import kotlinx.android.synthetic.main.reviews_rv_item.view.*

class ReviewsSeeAllAdapter: RecyclerView.Adapter<ReviewsSeeAllAdapter.MyViewHolder>() {

    private var movies = emptyList<MovieReviewsModel.Result>()

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(movie: MovieReviewsModel.Result) {
            itemView.reviews_username_Tv.text = movie.author
            itemView.reviews_review_dateTV.text = movie.created_at
            itemView.reviews_review_text_Tv.text = movie.content
            itemView.reviews_Userphoto_Iv.load("https://image.tmdb.org/t/p/original/${movie.author_details.avatar_path}")

        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.reviews_rv_item,
            parent, false
        )
        return ReviewsSeeAllAdapter.MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return movies.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(movies.get(position))

    }


    fun setData(movies: MovieReviewsModel) {
        this.movies = movies.results
    }
}