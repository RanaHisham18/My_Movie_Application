package com.rana.mymovieapplication.data.remote.datasource

import com.rana.mymovieapplication.services.TopRatedService

class TopRatedRemoteDataSource(val topRatedService: TopRatedService) {

    fun getTopRated(apiKey: String) {
        topRatedService.getTopRated(
            apikey = com.rana.mymovieapplication.BuildConfig.API_KEY,
            language = "en-US", page = 1
        )
    }
}