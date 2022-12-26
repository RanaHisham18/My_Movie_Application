package com.rana.mymovieapplication.data.remote.repos

import com.rana.mymovieapplication.BuildConfig
import com.rana.mymovieapplication.data.remote.entities.NowPlayingModel
import com.rana.mymovieapplication.data.remote.service.MoviesServices
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers

class MoviesRepo(private val moviesServices: MoviesServices) {


    fun getNowPlayingMovies(
        apiKey: String = BuildConfig.API_KEY,
        page: Int
    ): Single<NowPlayingModel> =
        moviesServices.getNowPlaying(apiKey = apiKey, page = page)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
}