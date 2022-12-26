package com.rana.mymovieapplication.data.remote.service

import com.rana.mymovieapplication.data.remote.entities.NowPlayingModel
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET

interface MoviesServices {

    @GET("movie/now_playing")
    fun getNowPlaying(
        apiKey: String,
        language: String = "en-US",
        page: Int
    ): Single<NowPlayingModel>
}