package com.rana.mymovieapplication.data.remote.entities

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class NowPlayingModel(
    val dates: Dates,
    val page: Int,
    val results: List<Result>,
    @Json(name = "total_pages") val totalPages: Int,
    val total_results: Int
) {

    data class Dates(
        val maximum: String,
        val minimum: String
    )

    data class Result(
        val adult: Boolean,
        val backdrop_path: String,
        val genre_ids: List<Int>,
        val id: Int,
        val original_language: String,
        val original_title: String,
        val overview: String,
        val popularity: Double,
        val poster_path: String,
        val release_date: String,
        val title: String,
        val video: Boolean,
        val vote_average: Double,
        val vote_count: Int
    )
}