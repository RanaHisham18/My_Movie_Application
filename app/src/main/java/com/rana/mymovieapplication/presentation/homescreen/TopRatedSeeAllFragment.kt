package com.rana.mymovieapplication.presentation.homescreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.rana.mymovieapplication.R
import com.rana.mymovieapplication.data.remote.entities.TopRatedModel
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_popular_see_all.*
import kotlinx.android.synthetic.main.fragment_toprated_see_all.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class TopRatedSeeAllFragment : Fragment() {
    private lateinit var TopRatedSeeAllAdapter: TopRatedAdapter
    private val viewModel: HomeViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_toprated_see_all, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

       TopRatedSeeAllAdapter = TopRatedSeeAllAdapter
       toprated_seeall_rv.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL,
           false)
        toprated_seeall_rv.adapter = TopRatedSeeAllAdapter


        viewModel.getTopRated()
        viewModel.topRatedLiveData.observe(viewLifecycleOwner) {
            when (it is TopRatedModel) {
                true -> {
                    TopRatedSeeAllAdapter.setData(it.results)
                    toprated_seeall_rv.adapter = TopRatedSeeAllAdapter
                }
                else -> {

                }
            }

        }

    }

}
