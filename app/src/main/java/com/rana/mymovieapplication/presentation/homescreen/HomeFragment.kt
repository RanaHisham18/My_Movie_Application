package com.rana.mymovieapplication.presentation.homescreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.rana.mymovieapplication.R
import kotlinx.android.synthetic.main.fragment_home.*


class HomeFragment : Fragment() {

//    private  lateinit var  nowplayrecyclerView: RecyclerView
//    private lateinit var nowplayingadapter: NowPlayingAdapter

    //first Rv
    private lateinit var playingNowAdapter: NowPlayingAdapter
    //second Rv
    private lateinit var popularFilmsAdapter: PopularFilmsAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
//       Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_home, container,
            false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //first Rv
        playingNowAdapter = NowPlayingAdapter()

        nowplaying_recyclerview.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL,
            false)
        nowplaying_recyclerview.adapter = playingNowAdapter

        //Second Rv
        popularFilmsAdapter = PopularFilmsAdapter()

        popular_recyclerview.layoutManager = LinearLayoutManager (activity, LinearLayoutManager.HORIZONTAL,
            false)
        popular_recyclerview.adapter =  popularFilmsAdapter













    }

}