package com.rana.mymovieapplication.services

import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieTrailerService {

    @GET("movie/{movie_id}/videos")
    fun getTrailer(
        @Path("movie_id")
        movie_id : Long,
        @Query("api_key")
        apikey: String,
        @Query("page")
        page : Int
    ): Single<MovieTrailerModel>
}