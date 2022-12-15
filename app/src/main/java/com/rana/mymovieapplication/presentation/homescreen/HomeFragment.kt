package com.rana.mymovieapplication.presentation.homescreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.rana.mymovieapplication.R
import kotlinx.android.synthetic.main.fragment_home.*


class HomeFragment : Fragment() {

//    private  lateinit var  nowplayrecyclerView: RecyclerView
//    private lateinit var nowplayingadapter: NowPlayingAdapter


    private lateinit var playingNowAdapter: NowPlayingAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
////         Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_home, container,
            false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        playingNowAdapter = NowPlayingAdapter()

        nowplaying_recyclerview.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        nowplaying_recyclerview.adapter = playingNowAdapter
    }

}