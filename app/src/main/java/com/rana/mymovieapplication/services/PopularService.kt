package com.rana.mymovieapplication.services

import com.rana.mymovieapplication.data.remote.entities.NowPlayingModel
import com.rana.mymovieapplication.data.remote.entities.PopularModel
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface PopularService {

    @GET("movie/popular")
    fun getPopular (
        @Query("api_key")
        apikey: String,
        @Query("language")
        language: String = "en-US",
        @Query("page")
        page : Int
    ): Single<PopularModel>
}

