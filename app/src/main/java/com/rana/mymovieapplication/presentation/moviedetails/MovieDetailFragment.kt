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
import com.rana.mymovieapplication.data.remote.entities.MovieDetailsModel
import com.rana.mymovieapplication.presentation.homescreen.HomeFragmentDirections
import com.rana.mymovieapplication.presentation.homescreen.HomeViewModel
import com.rana.mymovieapplication.presentation.homescreen.PopularFilmsAdapter
import kotlinx.android.synthetic.main.fragment_home.*
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

                else -> {}
            }


        }

        movieTrailerAdapter = MovieTrailerAdapter()
        trailers_Rv.layoutManager = LinearLayoutManager(
            activity, LinearLayoutManager.HORIZONTAL, false
        )

        }
    }







