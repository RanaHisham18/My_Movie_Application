package com.rana.mymovieapplication.data.remote.repository

import com.rana.mymovieapplication.BuildConfig
import com.rana.mymovieapplication.data.remote.entities.NowPlayingModel
import com.rana.mymovieapplication.data.remote.entities.PopularModel
import com.rana.mymovieapplication.data.remote.entities.TopRatedModel
import com.rana.mymovieapplication.services.NowPlayingService
import com.rana.mymovieapplication.services.PopularService
import com.rana.mymovieapplication.services.TopRatedService
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers


class MoviesRepository(
    val nowPlayingService: NowPlayingService,
    val topRatedService: TopRatedService,
    val popularService: PopularService
) {

    fun getNowPlayingFilms(
        apiKey: String = BuildConfig.API_KEY,
        page: Int
    ): Single<NowPlayingModel> = nowPlayingService.getNowPlaying(apiKey, page = page)
        .subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())


    //zip another services of the rest RVs


    fun getPopular(
        apiKey: String = BuildConfig.API_KEY,
        page: Int
    ): Single<PopularModel> =
        popularService.getPopular(apiKey, page = page).subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())


    fun getTopRated(apiKey: String = BuildConfig.API_KEY , page: Int): Single<TopRatedModel> =
        topRatedService.getTopRated(apiKey, page = page).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers) {}



}






