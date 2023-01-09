package com.rana.mymovieapplication.data.remote.datasource

import com.rana.mymovieapplication.BuildConfig
import com.rana.mymovieapplication.services.PopularService

class PopularRemoteDataSource(val popularService: PopularService) {

    fun getPopular(apiKey: String) {

        popularService.getPopular(apikey = BuildConfig.API_KEY, language = "en-US", page = 1)
    }
}