package com.rana.mymovieapplication.presentation.moviedetails

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import coil.load
import com.rana.mymovieapplication.R
import com.rana.mymovieapplication.data.remote.entities.MovieCastsModel
import com.rana.mymovieapplication.data.remote.entities.MovieDetailsModel
import com.rana.mymovieapplication.data.remote.entities.MovieReviewsModel
import com.rana.mymovieapplication.presentation.homescreen.HomeViewModel
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
                    movieDetail_rating_number_Tv.text= it.vote_count.toString()
                    movieDetail_dateTV.text = it.release_date
                    movieDetail_duration_Tv.text = it.runtime.toString()
                    movieDetail_overviewText_Tv.text = it.overview

                }

                else -> {
                }
            }
        }

        movieTrailerAdapter = MovieTrailerAdapter()
        trailers_Rv.layoutManager = LinearLayoutManager(
            activity, LinearLayoutManager.HORIZONTAL, false
        )


        viewModel.getReviews(args.movieId)
        viewModel.MovieReviewsLiveData.observe(viewLifecycleOwner){
            when (it is MovieReviewsModel) {
                true -> {
                    //to check
                    movieDetail_Userphoto_Iv.load("https://image.tmdb.org/t/p/original/${it.results[0].author_details.avatar_path}")
                    movieDetail_username_Tv.text = it.results[0].author
                    movieDetail_reviews_text_Tv.text =it.results[0].content
                    movieDetail_review_dateTV.text =it.results[0].created_at
                }
                else -> {

                }
            }
        }

        movieDetail_seeall_Tv.setOnClickListener (View.OnClickListener {
            findNavController().navigate(R.id.action_movieDetailFragment_to_reviewsFragment)
    })
//        viewModel.getCasts(args.movieId)
//        viewModel.MovieCastsLiveData.observe(viewLifecycleOwner){
//            when(it is MovieCastsModel){
//                true -> {
//                  movieDetail_casts_username_Tv.text = it.cast[0].name
//                  movieDetail_casts_username2_Tv.text = it.cast[1].name
//                    movieDetail_casts_userphoto_Tv.load("https://image.tmdb.org/t/p/original/${it.cast[0].profile_path}")
//                    movieDetail_casts_userphoto2_Tv.load("https://image.tmdb.org/t/p/original/${it.cast[1].profile_path}")
//                    movieDetail_casts_category_Tv.text = it.cast[0].known_for_department
//                    movieDetail_casts_category2_Tv.text = it.cast[1].known_for_department
//                }
//                else -> {
//
//                }
//            }
//
//        }



    } }







