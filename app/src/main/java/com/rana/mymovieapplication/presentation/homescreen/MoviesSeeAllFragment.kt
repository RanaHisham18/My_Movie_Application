package com.rana.mymovieapplication.presentation.homescreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.rana.mymovieapplication.R
import com.rana.mymovieapplication.data.remote.entities.MoviesModel
import com.rana.mymovieapplication.presentation.homescreen.recyclerview.MoviesSeeAllAdapter
import kotlinx.android.synthetic.main.fragment_movies_see_all.*
import kotlinx.android.synthetic.main.fragment_now_playing_see_all.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import kotlin.reflect.typeOf


class MoviesSeeAllFragment : Fragment() {

    private lateinit var moviesSeeAllAdapter: MoviesSeeAllAdapter

    private val viewModel: HomeViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movies_see_all, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getMovies(type = args.type)
        viewModel.topRatedLiveData.observe(viewLifecycleOwner) {
            moviesSeeAllAdapter.setData(it.results)
            movies_seeall_rv.adapter = moviesSeeAllAdapter
        }

        movies_seeall_rv.layoutManager = LinearLayoutManager(activity)

        viewModel.popularModelLiveData.observe(viewLifecycleOwner) {
            moviesSeeAllAdapter.setData(it.results)
            movies_seeall_rv.adapter = moviesSeeAllAdapter
        }
       movies_seeall_rv.layoutManager = LinearLayoutManager(activity)

        viewModel.nowPlayingLiveData.observe(viewLifecycleOwner) {
            moviesSeeAllAdapter.setData(it.results)
           movies_seeall_rv.adapter = moviesSeeAllAdapter
        }
       movies_seeall_rv.layoutManager = LinearLayoutManager(activity)


        moviesSeeAllAdapter = MoviesSeeAllAdapter(movieItemCallBack = {
            findNavController().navigate(MoviesSeeAllDirections.actionMoviesSeeAllToMovieDetails(it))
        })



    }
    }
}