package com.rana.mymovieapplication.presentation.homescreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.rana.mymovieapplication.R
import com.rana.mymovieapplication.data.remote.entities.NowPlayingModel
import com.rana.mymovieapplication.data.remote.entities.PopularModel
import kotlinx.android.synthetic.main.fragment_now_playing_see_all.*
import kotlinx.android.synthetic.main.fragment_popular_see_all.*
import org.koin.androidx.viewmodel.ext.android.viewModel


class PopularSeeAllFragment : Fragment() {
    private lateinit var popularSeeAllAdapter: PopularSeeAllAdapter
    private val viewModel: HomeViewModel by viewModel()

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
        popularseeall_rv.layoutManager =
            LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        popularseeall_rv.adapter = popularSeeAllAdapter


        viewModel.getPopular()
        viewModel.popularModelLiveData.observe(viewLifecycleOwner) {
            when (it is PopularModel) {
                true -> {
                  popularSeeAllAdapter.setData(it.results)
                    popularseeall_rv.adapter = popularSeeAllAdapter


                }
                else -> {

                }
            }
    }

} }
