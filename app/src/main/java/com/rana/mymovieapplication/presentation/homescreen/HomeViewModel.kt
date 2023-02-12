package com.rana.mymovieapplication.presentation.homescreen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.rana.mymovieapplication.data.remote.entities.*
import com.rana.mymovieapplication.data.remote.repository.MoviesRepository

class HomeViewModel(private val moviesRepository: MoviesRepository) : ViewModel() {

    private val nowPlayingResult: MutableLiveData<NowPlayingModel> by lazy {
        MutableLiveData()
    }
    val nowPlayingLiveData: LiveData<NowPlayingModel> = nowPlayingResult
    private val nowPlayingMError: MutableLiveData<String> by lazy {
        MutableLiveData()
    }
    val nowPlayingError: LiveData<NowPlayingModel> by lazy {
        MutableLiveData()
    }


    fun getNowPlaying() {
        moviesRepository.getNowPlayingFilms(page = 1).subscribe({ nowplayingModel ->
            nowPlayingResult.value = nowplayingModel
        },
            { errorThrowable -> nowPlayingMError.value = errorThrowable.localizedMessage })


    }

    private val popularResult: MutableLiveData<PopularModel> by lazy {
        MutableLiveData()
    }

    val popularModelLiveData: LiveData<PopularModel> = popularResult

    private val popularMError: MutableLiveData<String> by lazy {
        MutableLiveData()
    }
    val popularError: LiveData<PopularModel> by lazy {
        MutableLiveData()
    }

    fun getPopular() {
        moviesRepository.getPopular(page = 1).subscribe({ popularModel ->
            popularResult.value = popularModel
        },
            { errorThrowable -> popularMError.value = errorThrowable.localizedMessage })


    }

    private val topRatedResult: MutableLiveData<TopRatedModel> by lazy {
        MutableLiveData()
    }

    val topRatedLiveData: LiveData<TopRatedModel> = topRatedResult


    private val topRatedMError: MutableLiveData<String> by lazy {
        MutableLiveData()
    }
    val topRatedError: LiveData<TopRatedModel> by lazy {
        MutableLiveData()
    }

    fun getTopRated() {
        moviesRepository.getTopRated(page = 1).subscribe({ topratedModel ->
            topRatedResult.value = topratedModel
        },
            { errorThrowable -> topRatedMError.value = errorThrowable.localizedMessage })


    }


    private val moviecategoryResult: MutableLiveData<MovieCategoryModel> by lazy {
        MutableLiveData()
    }

    val MovieCategoryLiveData: LiveData<MovieCategoryModel> = moviecategoryResult


    private val movieCategoryMError: MutableLiveData<String> by lazy {
        MutableLiveData()
    }
    val movieCategoryError: LiveData<TopRatedModel> by lazy {
        MutableLiveData()
    }
    fun getCategory(){
        moviesRepository.getCategory(page = 1).subscribe({ moviecategoryModel ->
            moviecategoryResult.value = moviecategoryModel },
            { errorThrowable -> movieCategoryMError.value = errorThrowable.localizedMessage })


    }

    private val movievdetailsResult: MutableLiveData<MovieDetailsModel> by lazy {
        MutableLiveData()
    }

    val MovieDetailsLiveData: LiveData<MovieDetailsModel> = movievdetailsResult


    private val movieDetailsMError: MutableLiveData<String> by lazy {
        MutableLiveData()
    }
    val moviedetailsError: LiveData<MovieDetailsModel> by lazy {
        MutableLiveData()
    }
    fun getDetails(movieId : Long){
        moviesRepository.getDetails( movieId = movieId, page = 1).subscribe({ moviedetailsModel ->
            movievdetailsResult.value = moviedetailsModel },
            { errorThrowable -> movieDetailsMError.value = errorThrowable.localizedMessage })


    }


    private val movievTrailerResult: MutableLiveData<MovieTrailerModel> by lazy {
        MutableLiveData()
    }

    val MovieTrailerLiveData: LiveData<MovieTrailerModel> = movievTrailerResult

    private val movieTrailerMError: MutableLiveData<String> by lazy {
        MutableLiveData()
    }
    val movieTrailerError: LiveData<MovieDetailsModel> by lazy {
        MutableLiveData()
    }
    fun getTrailer(movieId : Long){
        moviesRepository.getTrailer( movieId = movieId, page = 1).subscribe({ movietrailerModel ->
            movievTrailerResult.value = movietrailerModel },
            { errorThrowable -> movieTrailerMError.value = errorThrowable.localizedMessage })


    }



    private val movievReviewsResult: MutableLiveData<MovieReviewsModel> by lazy {
        MutableLiveData()
    }

    val MovieReviewsLiveData: LiveData<MovieReviewsModel> = movievReviewsResult

    private val movieReviewsMError: MutableLiveData<String> by lazy {
        MutableLiveData()
    }
    val movieReviewsError: LiveData<MovieReviewsModel> by lazy {
        MutableLiveData()
    }
    fun getReviews(movieId : Long){
        moviesRepository.getTrailer( movieId = movieId, page = 1).subscribe({ movietrailerModel ->
            movievTrailerResult.value = movietrailerModel },
            { errorThrowable -> movieTrailerMError.value = errorThrowable.localizedMessage })


    }


    private val movievCastsResult: MutableLiveData<MovieCastsModel> by lazy {
        MutableLiveData()
    }

    val MovieCastsLiveData: LiveData<MovieCastsModel> = movievReviewsResult

    private val movieReviewsMError: MutableLiveData<String> by lazy {
        MutableLiveData()
    }
    val movieReviewsError: LiveData<MovieReviewsModel> by lazy {
        MutableLiveData()
    }
    fun getReviews(movieId : Long){
        moviesRepository.getTrailer( movieId = movieId, page = 1).subscribe({ movietrailerModel ->
            movievTrailerResult.value = movietrailerModel },
            { errorThrowable -> movieTrailerMError.value = errorThrowable.localizedMessage })


    }

}