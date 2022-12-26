package com.rana.mymovieapplication.presentation.homescreen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.rana.mymovieapplication.data.remote.entities.NowPlayingModel
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

}