package com.rana.mymovieapplication.services

import com.rana.mymovieapplication.data.remote.entities.NowPlayingModel
import retrofit2.http.GET
import io.reactivex.rxjava3.core.Single



interface NowPlayingService {

    @GET("movie/now_playing")
    fun getNowPlaying (
        apikey: String,
        language: String = "en-US",
        page : Int
    ): Single<NowPlayingModel>

}