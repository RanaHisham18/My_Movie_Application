package com.rana.mymovieapplication.services

import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface NewSessionService {

    @POST("/authentication/session/new")
    fun establishNewSession(
        @Path("request_token")
        requesttoken: String,
        @Query("api_key")
        apikey: String
    )
}