package com.rana.mymovieapplication.services

import com.rana.mymovieapplication.data.remote.entities.RequestTokenModel
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface RequestTokenService {

    @GET("/authentication/token/new")
    fun getToken (
        @Query("api_key")
        apikey: String
    ):Single<RequestTokenModel>
}