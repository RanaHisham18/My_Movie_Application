package com.rana.mymovieapplication.data.remote.repository

import com.rana.mymovieapplication.BuildConfig
import com.rana.mymovieapplication.data.remote.entities.NowPlayingModel
import com.rana.mymovieapplication.data.remote.entities.PopularModel
import com.rana.mymovieapplication.data.remote.entities.TopRatedModel
import com.rana.mymovieapplication.services.NowPlayingService
import com.rana.mymovieapplication.services.PopularService
import com.rana.mymovieapplication.services.TopRatedService
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers


class MoviesRepository(
    private val nowPlayingService: NowPlayingService,
    private val topRatedService: TopRatedService,
    private val popularService: PopularService, 
    private val ioScheduler: Scheduler,
    private val mainScheduler: Scheduler
) {

    fun getNowPlayingFilms(
        apiKey: String = BuildConfig.API_KEY,
        page: Int
    ): Single<NowPlayingModel> = nowPlayingService.getNowPlaying(apiKey, page = page)
        .subscribeOn(ioScheduler).observeOn(mainScheduler)


    //zip another services of the rest RVs


    fun getPopular(
        apiKey: String = BuildConfig.API_KEY,
        page: Int
    ): Single<PopularModel> =
        popularService.getPopular(apiKey, page = page).subscribeOn(ioScheduler)
            .observeOn(mainScheduler)




    fun getTopRated(apiKey: String = BuildConfig.API_KEY,
                    page: Int
    ): Single<TopRatedModel> =
        topRatedService.getTopRated(apiKey, page = page).subscribeOn(ioScheduler)
            .observeOn(mainScheduler)


}






