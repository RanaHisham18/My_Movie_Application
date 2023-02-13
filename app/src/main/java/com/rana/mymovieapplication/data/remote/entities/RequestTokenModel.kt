package com.rana.mymovieapplication.data.remote.entities

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class RequestTokenModel(
    val expires_at: String,
    val request_token: String,
    val success: Boolean
)