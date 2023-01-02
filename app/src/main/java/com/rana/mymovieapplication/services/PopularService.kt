package com.rana.mymovieapplication.services

import com.rana.mymovieapplication.data.remote.entities.NowPlayingModel
import com.rana.mymovieapplication.data.remote.entities.PopularModel
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET

interface PopularService {

    @GET("/movie/popular")
    fun getPopular (
        apikey: String,
        language: String = "en-US",
        page : Int
    ): Single<PopularModel>
}

