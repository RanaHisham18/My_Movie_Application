package com.rana.mymovieapplication.presentation.homescreen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.rana.mymovieapplication.data.remote.entities.NowPlayingModel
import com.rana.mymovieapplication.data.remote.entities.PopularModel
import com.rana.mymovieapplication.data.remote.entities.TopRatedModel
import com.rana.mymovieapplication.data.remote.repository.MoviesRepository

class HomeViewModel(private val moviesRepository: MoviesRepository) : ViewModel() {
    private val m_result: MutableLiveData<NowPlayingModel> by lazy {
        MutableLiveData()
    }

    val result: LiveData<NowPlayingModel> = m_result

    private val m_error: MutableLiveData<String> by lazy {
        MutableLiveData()
    }
    val error: LiveData<NowPlayingModel> by lazy {
        MutableLiveData()
    }

    fun getNowPlaying() {
        moviesRepository.getNowPlayingFilms(page = 1).subscribe({ nowplayingModel ->
            m_result.value = nowplayingModel
        },
            { errorThrowable -> m_error.value = errorThrowable.localizedMessage })


    }
    ///////////////////////////////////////////////////////////////
    private val m_result2: MutableLiveData<PopularModel> by lazy {
        MutableLiveData()
    }

    val result2: LiveData<PopularModel> = m_result2

    private val m_error2: MutableLiveData<String> by lazy {
        MutableLiveData()
    }
    val error2: LiveData<PopularModel> by lazy {
        MutableLiveData()
    }

    fun getPopular() {
        moviesRepository.getPopular(page = 1).subscribe({ popularModel ->
            m_result2.value = popularModel
        },
            { errorThrowable -> m_error2.value = errorThrowable.localizedMessage })


    }
////////////////////////////////////////////////////////////////////////
private val m_result3: MutableLiveData<TopRatedModel> by lazy {
    MutableLiveData()
}

    val result3: LiveData<TopRatedModel> = m_result3

    private val m_error3: MutableLiveData<String> by lazy {
        MutableLiveData()
    }
    val error3: LiveData<TopRatedModel> by lazy {
        MutableLiveData()
    }

    fun getTopRated() {
        moviesRepository.

        getTopRated(page = 1).subscribe({ topratedModel ->
            m_result3.value = topratedModel
        },
            { errorThrowable -> m_error3.value = errorThrowable.localizedMessage })


    }
}