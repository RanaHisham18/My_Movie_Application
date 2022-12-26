package com.rana.mymovieapplication.presentation.homescreen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.rana.mymovieapplication.data.remote.entities.NowPlayingModel
import com.rana.mymovieapplication.data.remote.repos.MoviesRepo

class HomeViewModel(private val repo: MoviesRepo) : ViewModel() {

    private val _result: MutableLiveData<NowPlayingModel> by lazy {
        MutableLiveData()
    }

    val result: LiveData<NowPlayingModel> = _result

    private val _error: MutableLiveData<String> by lazy {
        MutableLiveData()
    }

    val error: LiveData<String> = _error

    fun getNowPlaying() {
        repo.getNowPlayingMovies(page = 1)

            .subscribe({ nowPlayingModel ->
            _result.value = nowPlayingModel
        }, { errorThrowable ->
            _error.value = errorThrowable.localizedMessage
        })

    }
}