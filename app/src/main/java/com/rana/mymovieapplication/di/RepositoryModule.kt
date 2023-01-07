package com.rana.mymovieapplication.di

import com.rana.mymovieapplication.data.remote.repository.MoviesRepository
import org.koin.dsl.module

val moviesRepositoryModule = module {
    single{
        MoviesRepository(nowPlayingService = get(), topRatedService = get(), popularService = get())
    }


}