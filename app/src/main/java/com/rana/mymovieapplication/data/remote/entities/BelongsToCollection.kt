package com.rana.mymovieapplication.data.remote.entities

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class BelongsToCollection(
    val backdrop_path: String,
    val id: Int,
    val name: String,
    val poster_path: String
)