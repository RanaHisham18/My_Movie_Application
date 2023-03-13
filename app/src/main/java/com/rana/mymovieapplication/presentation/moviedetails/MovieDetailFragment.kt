package com.rana.mymovieapplication.presentation.moviedetails

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isGone
import androidx.navigation.fragment.NavHostFragment


import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import coil.load
import com.rana.mymovieapplication.R
import com.rana.mymovieapplication.data.remote.entities.MovieCastsModel
import com.rana.mymovieapplication.data.remote.entities.MovieDetailsModel
import com.rana.mymovieapplication.data.remote.entities.MovieReviewsModel
import com.rana.mymovieapplication.data.remote.entities.MovieTrailerModel
import com.rana.mymovieapplication.presentation.homescreen.HomeViewModel
import com.rana.mymovieapplication.presentation.reviewscreen.ReviewsFragmentDirections
import kotlinx.android.synthetic.main.fragment_home.view.*
import kotlinx.android.synthetic.main.fragment_movie_detail.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class MovieDetailFragment : Fragment() {

    private lateinit var movieTrailerAdapter: MovieTrailerAdapter

    private val viewModel: HomeViewModel by viewModel()

    val args by navArgs<MovieDetailFragmentArgs>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movie_detail, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        args.movieId
        viewModel.getDetails(args.movieId)
        viewModel.MovieDetailsLiveData.observe(viewLifecycleOwner) {
            when (it is MovieDetailsModel) {
                true -> {
                    movieDetail_filmname_Tv.text = it.original_title
                    film_poster_Iv.load("https://image.tmdb.org/t/p/original/${it.poster_path}")
                    movieDetail_rating_number_Tv.text = it.vote_count.toString()
                    movieDetail_dateTV.text = it.release_date
                    movieDetail_duration_Tv.text = it.runtime.toString()
                    movieDetail_overviewText_Tv.text = it.overview

                }

                else -> {
                }
            }
        }

       movieTrailerAdapter = MovieTrailerAdapter(movieItemCallBack = {
            val urlIntent = Intent(Intent.ACTION_VIEW)
            urlIntent.data = Uri.parse("https://www.youtube.com/watch?v=${it}")
            requireActivity().startActivity(urlIntent)
        })
        viewModel.getTrailer(args.movieId)
        viewModel.MovieTrailerLiveData.observe(viewLifecycleOwner){
            if(it is MovieTrailerModel){
                Log.d("trailercheck", it.results.toString())
                movieTrailerAdapter.setData(it.results)
                trailers_Rv.adapter = movieTrailerAdapter
            }
        }
      trailers_Rv.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        viewModel.getMovieReviews(args.movieId)

        viewModel.movieReviewsLiveData.observe(viewLifecycleOwner) {
            when (it.results.isNotEmpty()) {
                true -> {
                    //to check
                    Log.d("Success", "Data Success $it")
                    movieDetail_Userphoto_Iv.load("https://image.tmdb.org/t/p/original/${it.results[0].author_details.avatar_path}")
                    movieDetail_username_Tv.text = it.results[0].author
                    movieDetail_reviews_text_Tv.text = it.results[0].content
                    movieDetail_review_dateTV.text = it.results[0].created_at
                    noreview_tv.visibility = View.GONE
                }
                else -> {
                    movieDetail_Userphoto_Iv.visibility = View.GONE
                    movieDetail_username_Tv.visibility = View.GONE
                    movieDetail_reviews_text_Tv.visibility= View.GONE
                    movieDetail_review_dateTV.visibility= View.GONE
                    noreview_tv.visibility = View.VISIBLE
                    movieDetail_seeall_Tv.visibility = View.GONE
                }
            }
        }

        viewModel.movieReviewsLiveDataError.observe(viewLifecycleOwner) {
        }

        movieDetail_seeall_Tv.setOnClickListener(View.OnClickListener {
            findNavController().navigate(R.id.action_movieDetailFragment_to_reviewsFragment)
        })
        viewModel.getMovieCast(args.movieId)
        viewModel.movieCastLiveData.observe(viewLifecycleOwner) {
            when (it is MovieCastsModel) {
                true -> {
                    movieDetail_casts_username_Tv.text = it.cast[0].name
                    movieDetail_casts_username2_Tv.text = it.cast[1].name
                    movieDetail_casts_userphoto_Tv.load("https://image.tmdb.org/t/p/original/${it.cast[0].profile_path}")
                    movieDetail_casts_userphoto2_Tv.load("https://image.tmdb.org/t/p/original/${it.cast[1].profile_path}")
                    movieDetail_casts_category_Tv.text = it.cast[0].known_for_department
                    movieDetail_casts_category2_Tv.text = it.cast[1].known_for_department
                }
                else -> {

                }
            }

        }
        viewModel.movieCastLiveDataError.observe(viewLifecycleOwner) {
            Log.d("Failure", "Error $it")
        }

       movieDetail_seeall_Tv.setOnClickListener(){
           findNavController().navigate(MovieDetailFragmentDirections.actionMovieDetailFragmentToReviewsFragment(args.movieId))
       }

        //backarrow_icon_Iv.setOnClickListener() { findNavController().navigate(ReviewsFragmentDirections
         //   .actionReviewsFragmentToMovieDetailFragment(args.movieId) ) }
        backarrow_icon_Iv.setOnClickListener(){
            findNavController().navigate(R.id.homeFragment)
        }
    }

    fun playVideos(key: String) {
        val urlIntent = Intent(Intent.ACTION_VIEW)
        urlIntent.data = Uri.parse("https://www.youtube.com/watch?v=${key}")
        requireActivity().startActivity(urlIntent)
    }

}







