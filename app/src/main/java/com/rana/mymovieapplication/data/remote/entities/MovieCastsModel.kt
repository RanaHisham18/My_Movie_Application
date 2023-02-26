package com.rana.mymovieapplication.data.remote.entities

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class MovieCastsModel(
    val cast: List<Cast>,
    val crew: List<Crew>,
    val id: Int
)