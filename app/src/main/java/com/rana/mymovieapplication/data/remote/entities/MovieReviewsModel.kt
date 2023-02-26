package com.rana.mymovieapplication.data.remote.entities

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class MovieReviewsModel(
    val id: Int,
    val page: Int,
    val results: List<Result>,
    val total_pages: Int,
    val total_results: Int
) {
    @JsonClass(generateAdapter = true)
    data class Result(
        val author: String,
        val author_details: AuthorDetails,
        val content: String,
        val created_at: String,
        val id: String,
        val updated_at: String,
        val url: String
    )
    @JsonClass(generateAdapter = true)
    data class AuthorDetails(
        val avatar_path: String?,
        val name: String?,
        val rating: Double?,
        val username: String?
    )
}