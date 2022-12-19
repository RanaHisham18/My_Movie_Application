package com.rana.mymovieapplication.presentation.homescreen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.rana.mymovieapplication.R
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_popular_see_all.*
import kotlinx.android.synthetic.main.popular_rv_item.*


class PopularSeeAllFragment : Fragment() {
private lateinit var popularSeeAllAdapter: PopularSeeAllAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_popular_see_all, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        popularSeeAllAdapter = PopularSeeAllAdapter()
        popularseeall_rv.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        popularseeall_rv.adapter = popularSeeAllAdapter
    }

    }
