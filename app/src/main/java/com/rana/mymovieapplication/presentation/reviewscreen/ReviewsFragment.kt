package com.rana.mymovieapplication.presentation.reviewscreen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.rana.mymovieapplication.R
import com.rana.mymovieapplication.data.remote.entities.MovieReviewsModel
import com.rana.mymovieapplication.presentation.homescreen.HomeViewModel
import com.rana.mymovieapplication.presentation.moviedetails.MovieDetailFragmentArgs
import org.koin.androidx.viewmodel.ext.android.viewModel


class ReviewsFragment : Fragment() {

    private val viewModel: HomeViewModel by viewModel()

    val args by navArgs<MovieDetailFragmentArgs>()





    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_reviews, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        args.movieId
        viewModel.getReviews(args.movieId)
        viewModel.MovieReviewsLiveData.observe(viewLifecycleOwner){
            when (it is MovieReviewsModel){

               true-> {


               }
                else -> {}
            }
        }
    }


    }
