package com.rana.mymovieapplication.data.remote.repository

import android.content.SharedPreferences
import com.rana.mymovieapplication.BuildConfig
import com.rana.mymovieapplication.data.remote.entities.*
import com.rana.mymovieapplication.services.*
import com.rana.mymovieapplication.utils.serialize
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.core.Single


class MoviesRepository(
    private val nowPlayingService: NowPlayingService,
    private val topRatedService: TopRatedService,
    private val popularService: PopularService,
    private val categoryService: MovieCategoryService,
    private val detailsService: MovieDetailsService,
    private val trailerService: MovieTrailerService,
    private val ioScheduler: Scheduler,
    private val mainScheduler: Scheduler,
    private val sharedPreferences: SharedPreferences
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


    fun getTopRated(
        apiKey: String = BuildConfig.API_KEY,
        page: Int
    ): Single<TopRatedModel> =
        topRatedService.getTopRated(apiKey, page = page).subscribeOn(ioScheduler)
            .observeOn(mainScheduler)


    fun getCategory(
        apiKey: String = BuildConfig.API_KEY,
        page: Int
    ): Single<MovieCategoryModel> =
        categoryService.getCategory(apiKey, page = page).subscribeOn(ioScheduler)
            .observeOn(mainScheduler).doOnSuccess {
                val editor = sharedPreferences.edit()

                editor.apply {
                    putString("My Movie Application", it.genres.serialize())
                }

            }


    fun getDetails(
        movieId: Long,
        apiKey: String = BuildConfig.API_KEY,
        page: Int
    ): Single<MovieDetailsModel> =
        detailsService.getDetails(movieId, apiKey, page = page).subscribeOn(ioScheduler)
            .observeOn(mainScheduler)


    fun getTrailer(
        movieId: Long,
        apiKey: String = BuildConfig.API_KEY,
        page: Int
    ): Single<MovieTrailerModel> =
        trailerService.getTrailer(movieId, apiKey, page = page).subscribeOn(ioScheduler)
            .observeOn(mainScheduler)
}






