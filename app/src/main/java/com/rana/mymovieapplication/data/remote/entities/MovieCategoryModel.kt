package com.rana.mymovieapplication.data.remote.entities

import com.squareup.moshi.JsonClass



@JsonClass(generateAdapter = true)
data class MovieCategoryModel(
    val genres: List<Genre>
) {

@JsonClass(generateAdapter = true)
data class Genre(
    val id: Int,
    val name: String
) }