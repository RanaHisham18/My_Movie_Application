package com.rana.mymovieapplication.presentation.homescreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.rana.mymovieapplication.R
import com.rana.mymovieapplication.data.remote.entities.NowPlayingModel
import kotlinx.android.synthetic.main.fragment_home.*


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


    private val viewModel: HomeViewModel by viewModels()
    lateinit var filmname_Tv: TextView
    lateinit var film_image: TextView


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
//       Inflate the layout for this fragment


//
        return inflater.inflate(
            R.layout.fragment_home, container,
            false
        )

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //first Rv
        playingNowAdapter = NowPlayingAdapter()

        nowplaying_recyclerview.layoutManager = LinearLayoutManager(
            activity, LinearLayoutManager.HORIZONTAL,
            false
        )

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


    }

}