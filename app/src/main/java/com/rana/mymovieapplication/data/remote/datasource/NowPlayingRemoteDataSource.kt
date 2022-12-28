package com.rana.mymovieapplication.data.remote.datasource

import com.rana.mymovieapplication.BuildConfig
import com.rana.mymovieapplication.services.NowPlayingService

class NowPlayingRemoteDataSource(val nowPlayingService: NowPlayingService) {
      fun getNowPlayingFilms (apiKey: String){
      nowPlayingService.getNowPlaying(apikey = BuildConfig.API_KEY, language = "en-US", page = 1)




}
}