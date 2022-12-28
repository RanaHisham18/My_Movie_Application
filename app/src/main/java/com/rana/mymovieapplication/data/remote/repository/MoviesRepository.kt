package com.rana.mymovieapplication.data.remote.repository

import com.rana.mymovieapplication.BuildConfig
import com.rana.mymovieapplication.data.remote.entities.NowPlayingModel
import com.rana.mymovieapplication.services.NowPlayingService
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers


class MoviesRepository (val nowPlayingService: NowPlayingService) {

    fun getNowPlayingFilms(
        apiKey : String = BuildConfig.API_KEY,
        page : Int
        ): Single<NowPlayingModel> = nowPlayingService.getNowPlaying(apiKey,page = page)
        .subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).zipWith(nowPlayingService.getNowPlaying
            (apiKey, language = "en_US", page =1), ) //TODO
}


