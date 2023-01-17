package com.rana.mymovieapplication.data.remote.entities

import androidx.lifecycle.GeneratedAdapter
import com.google.gson.annotations.JsonAdapter
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Genre(
    val id: Int,
    val name: String
)