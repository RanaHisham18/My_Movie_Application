package com.rana.mymovieapplication.services

import com.rana.mymovieapplication.data.remote.entities.MovieCategoryModel
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieCategoryService {
    @GET("genre/movie/list")
    fun getCategory (
        @Query("api_key")
        apikey: String,
        @Query("language")
        language: String = "en-US",
        @Query("page")
        page : Int
    ): Single<MovieCategoryModel>
}