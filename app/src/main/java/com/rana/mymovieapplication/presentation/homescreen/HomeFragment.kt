package com.rana.mymovieapplication.presentation.homescreen

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.SnapHelper
import com.rana.mymovieapplication.R
import com.rana.mymovieapplication.data.remote.entities.*
import com.rana.mymovieapplication.presentation.moviedetails.MovieDetailFragment
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.popular_rv_item.*
import org.koin.androidx.viewmodel.ext.android.viewModel


class HomeFragment : Fragment() {

    //first Rv
    private lateinit var playingNowAdapter: NowPlayingAdapter

    //second Rv
    private lateinit var popularFilmsAdapter: PopularFilmsAdapter

    //third Rv
    private lateinit var topRatedAdapter: TopRatedAdapter

    private val viewModel: HomeViewModel by viewModel()
    private lateinit var movieId: String


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        return inflater.inflate(
            R.layout.fragment_home, container, false
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //first Rv
        playingNowAdapter = NowPlayingAdapter(movieItemCallBack = {
            findNavController().navigate(
                HomeFragmentDirections
                    .actionHomeFragmentToMovieDetailFragment(it)
            )

        })
        val snapHelperPlayingNow: SnapHelper = LinearSnapHelper()
        snapHelperPlayingNow.attachToRecyclerView(nowplaying_recyclerview)

        nowplaying_recyclerview.layoutManager = LinearLayoutManager(
            activity, LinearLayoutManager.HORIZONTAL, false
        )

        //Second Rv
        popularFilmsAdapter = PopularFilmsAdapter(movieItemCallBack = {
            findNavController().navigate(
                HomeFragmentDirections
                    .actionHomeFragmentToMovieDetailFragment(it)
            )

        })

        popular_recyclerview.layoutManager = LinearLayoutManager(
            activity, LinearLayoutManager.HORIZONTAL, false
        )

        //third Rv
        topRatedAdapter = TopRatedAdapter(movieItemCallBack = {
            findNavController().navigate(HomeFragmentDirections
                .actionHomeFragmentToMovieDetailFragment(it))

        })
        toprated_recyclerview.layoutManager = LinearLayoutManager(
            activity, LinearLayoutManager.HORIZONTAL, false
        )

        viewModel.getNowPlaying()
        viewModel.nowPlayingLiveData.observe(viewLifecycleOwner) {
            when (it is NowPlayingModel) {
                true -> {
                    playingNowAdapter.setData(it.results)
                    nowplaying_recyclerview.adapter = playingNowAdapter
                }
                else -> {

                }
            }
        }

        viewModel.getPopular()
        viewModel.popularModelLiveData.observe(viewLifecycleOwner) {
            when (it is PopularModel) {
                true -> {
                    popularFilmsAdapter.setData(it.results)
                    popular_recyclerview.adapter = popularFilmsAdapter
                }
                else -> {

                }
            }
        }

        viewModel.getTopRated()
        viewModel.topRatedLiveData.observe(viewLifecycleOwner) {
            when (it is TopRatedModel) {
                true -> {
                    topRatedAdapter.setData(it.results)
                    toprated_recyclerview.adapter = topRatedAdapter
                }
                else -> {

                }
            }

        }

        viewModel.getCategory()
        viewModel.MovieCategoryLiveData.observe(viewLifecycleOwner) {
            when (it is MovieCategoryModel) {
                true -> {
                    val sharedPreferences: SharedPreferences = requireActivity()
                        .getSharedPreferences("My Movie Application", Context.MODE_PRIVATE)

                    Log.d(
                        HomeFragment::class.java.simpleName,
                        "First Category  " + it.genres[0].id.toString() + " " + it.genres[0].name
                    )

                    Log.d(
                        HomeFragment::class.java.simpleName,
                        "Shared Preferences" + sharedPreferences.all
                    )
                }
                else -> {

                }
            }
        }


        //to be checked
        nowplay_seeAll_TextView.setOnClickListener(View.OnClickListener {
            val navHostFragment =
                activity?.supportFragmentManager?.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
            val navController = navHostFragment.navController
            navController.navigate(R.id.nowPlayingSeeAllFragment)
        })

        popular_seeAll_TextView.setOnClickListener(View.OnClickListener {
            val navHostFragment =
                activity?.supportFragmentManager?.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
            val navController = navHostFragment.navController
            navController.navigate(R.id.popularSeeAllFragment)
        })

        toprated_seeAll_TextView.setOnClickListener(View.OnClickListener {
            val navHostFragment =
                activity?.supportFragmentManager?.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
            val navController = navHostFragment.navController
            navController.navigate(R.id.topRatedSeeAllFragment)
        })


    }

}


