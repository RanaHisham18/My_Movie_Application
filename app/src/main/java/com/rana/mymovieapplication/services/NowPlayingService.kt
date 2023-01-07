package com.rana.mymovieapplication.services

import com.rana.mymovieapplication.data.remote.entities.NowPlayingModel
import retrofit2.http.GET
import io.reactivex.rxjava3.core.Single
import retrofit2.http.Query


interface NowPlayingService {

    @GET("movie/now_playing")
    fun getNowPlaying (
        @Query("api_key")
        apikey: String,
        @Query("language")
        language: String = "en-US",
        @Query("page")
        page : Int
    ): Single<NowPlayingModel>

}