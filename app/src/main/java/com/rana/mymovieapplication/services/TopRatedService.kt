package com.rana.mymovieapplication.services

import com.rana.mymovieapplication.data.remote.entities.NowPlayingModel
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET

interface TopRatedService {

    @GET("/movie/top_rated")
    fun getTopRated (
        apikey: String,
        language: String = "en-US",
        page : Int
    ): Single<NowPlayingModel>
}