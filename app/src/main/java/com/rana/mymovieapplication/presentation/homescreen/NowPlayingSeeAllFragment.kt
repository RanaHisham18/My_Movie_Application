package com.rana.mymovieapplication.presentation.homescreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.rana.mymovieapplication.R
import kotlinx.android.synthetic.main.fragment_home.*
import org.koin.androidx.viewmodel.ext.android.viewModel


class NowPlayingSeeAllFragment : Fragment() {

    private lateinit var nowPlayingSeeAllAdapter: NowPlayingSeeAllAdapter

    private val viewModel: HomeViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_now_playing_see_all, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        nowPlayingSeeAllAdapter = NowPlayingSeeAllAdapter()

        nowplaying_recyclerview.layoutManager = LinearLayoutManager(
            activity, LinearLayoutManager.VERTICAL,
            false
        )


    }


}