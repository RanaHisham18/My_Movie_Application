package com.rana.mymovieapplication.presentation.homescreen

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.rana.mymovieapplication.R
import com.rana.mymovieapplication.data.remote.entities.NowPlayingModel
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.nowplaying_rv_item.*
import org.koin.androidx.viewmodel.ext.android.viewModel


class HomeFragment : Fragment() {

//    private  lateinit var  nowplayrecyclerView: RecyclerView
//    private lateinit var nowplayingadapter: NowPlayingAdapter

    //first Rv
    private lateinit var playingNowAdapter: NowPlayingAdapter

    //second Rv
    private lateinit var popularFilmsAdapter: PopularFilmsAdapter

    //third Rv
    private lateinit var topRatedAdapter: TopRatedAdapter

    private lateinit var button: Button


    private val viewModel: HomeViewModel by viewModel()
    lateinit var filmname_Tv: TextView
    lateinit var film_image: TextView


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
//       Inflate the layout for this fragment


//
        Log.d(HomeFragment::class.java.simpleName, "onCreateView: ")
        return inflater.inflate(
            R.layout.fragment_home, container,
            false
        )

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d(HomeFragment::class.java.simpleName, "onViewCreated: ")
        viewModel.getNowPlaying()
        viewModel.result.observe(viewLifecycleOwner) {
            Log.d(HomeFragment::class.java.simpleName, "onViewCreated: ${it.results}")
        }
        //first Rv
        playingNowAdapter = NowPlayingAdapter()

        nowplaying_recyclerview.layoutManager = LinearLayoutManager(
            activity, LinearLayoutManager.HORIZONTAL,
            false
        )
        nowplaying_recyclerview.adapter = playingNowAdapter

        //Second Rv
        popularFilmsAdapter = PopularFilmsAdapter()

        popular_recyclerview.layoutManager = LinearLayoutManager(
            activity, LinearLayoutManager.HORIZONTAL,
            false
        )
        popular_recyclerview.adapter = popularFilmsAdapter

        //third Rv
        topRatedAdapter = TopRatedAdapter()
        toprated_recyclerview.layoutManager = LinearLayoutManager(
            activity, LinearLayoutManager.HORIZONTAL,
            false
        )
        toprated_recyclerview.adapter = topRatedAdapter


//        seeAll_TextView.setOnClickListener {
//            val navHostFragment = activity?.supportFragmentManager?.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
//            val navControllerr = navHostFragment.navController
//
//            navControllerr.navigate(R.id.nowPlayingSeeAllFragment)
//        }


    }

    override fun onStart() {
        super.onStart()
        Log.d(HomeFragment::class.java.simpleName, "onStart: ")
    }

    override fun onResume() {
        super.onResume()

    }

    override fun onDestroy() {
        super.onDestroy()
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }
}