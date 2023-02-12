package com.rana.mymovieapplication.data.remote.entities

data class MovieCastsModel(
    val cast: List<Cast>,
    val crew: List<Crew>,
    val id: Int
)