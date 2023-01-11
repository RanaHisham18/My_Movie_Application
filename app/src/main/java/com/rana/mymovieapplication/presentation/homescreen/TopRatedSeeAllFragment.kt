package com.rana.mymovieapplication.presentation.homescreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.rana.mymovieapplication.R
import kotlinx.android.synthetic.main.fragment_popular_see_all.*

class TopRatedSeeAllFragment : Fragment() {
    private lateinit var TopRatedSeeAllAdapter: TopRatedAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_toprated_see_all, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

       TopRatedSeeAllAdapter = TopRatedAdapter()
        popularseeall_rv.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        popularseeall_rv.adapter = TopRatedSeeAllAdapter
    }

}
