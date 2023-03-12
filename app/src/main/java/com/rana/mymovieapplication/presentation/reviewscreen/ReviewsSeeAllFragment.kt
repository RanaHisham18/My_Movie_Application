package com.rana.mymovieapplication.presentation.reviewscreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.rana.mymovieapplication.R
import com.rana.mymovieapplication.data.remote.entities.MovieReviewsModel
import com.rana.mymovieapplication.presentation.homescreen.HomeViewModel
import com.rana.mymovieapplication.presentation.moviedetails.MovieDetailFragmentArgs
import kotlinx.android.synthetic.main.fragment_reviews.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class ReviewsSeeAllFragment : Fragment() {
    private lateinit var reviewsSeeAllAdapter: ReviewsSeeAllAdapter
    private val viewModel: HomeViewModel by viewModel()
    private val args by navArgs<MovieDetailFragmentArgs>()



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_reviews, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        reviewsSeeAllAdapter = ReviewsSeeAllAdapter()
        reviews_rv.layoutManager =
            LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        reviews_rv.adapter = reviewsSeeAllAdapter

        viewModel.getMovieReviews(args.movieId)
        viewModel.movieReviewsLiveData.observe(viewLifecycleOwner) {
            when (it is MovieReviewsModel) {
                true -> {
                    reviewsSeeAllAdapter.setData(it)
                  reviews_rv.adapter = reviewsSeeAllAdapter


                }
                else -> {

                }
            }
    }

}}