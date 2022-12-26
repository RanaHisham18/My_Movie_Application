package com.rana.mymovieapplication.presentation.homescreen

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.rana.mymovieapplication.R
import kotlinx.android.synthetic.main.fragment_home.*
import org.koin.androidx.viewmodel.ext.android.viewModel


class HomeFragment : Fragment() {

//    private  lateinit var  nowplayrecyclerView: RecyclerView
//    private lateinit var nowplayingadapter: NowPlayingAdapter

    private val viewmodel: HomeViewModel by viewModel()

    //first Rv
    private lateinit var playingNowAdapter: NowPlayingAdapter

    //second Rv
    private lateinit var popularFilmsAdapter: PopularFilmsAdapter

    //third Rv
    private lateinit var topRatedAdapter: TopRatedAdapter

    private lateinit var button: Button


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
//       Inflate the layout for this fragment

        return inflater.inflate(
            R.layout.fragment_home, container,
            false
        )

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewmodel.result.observe(viewLifecycleOwner) {
            //hena ana m3aya el data

        }

        viewmodel.error.observe(viewLifecycleOwner){
            Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
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

}