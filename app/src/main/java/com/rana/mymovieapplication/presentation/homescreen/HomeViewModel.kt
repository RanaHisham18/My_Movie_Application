package com.rana.mymovieapplication.presentation.homescreen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.rana.mymovieapplication.data.remote.entities.NowPlayingModel
import com.rana.mymovieapplication.data.remote.entities.PopularModel
import com.rana.mymovieapplication.data.remote.entities.TopRatedModel
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
}