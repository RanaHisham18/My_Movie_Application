package com.rana.mymovieapplication.services

import android.telecom.Call
import com.rana.mymovieapplication.data.remote.entities.MovieCategoryModel
import com.rana.mymovieapplication.data.remote.entities.MovieDetailsModel
import com.rana.mymovieapplication.data.remote.entities.NowPlayingModel
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieDetailsService {

    @GET("movie/{movie_id}")
    fun getDetails(
        @Path("movie_id")
        movie_id: String,
        @Query("api_key")
        apikey: String,
        @Query("language")
        language: String = "en-US",
        @Query("page")
        page: Int
    ): Single<MovieDetailsModel>

}