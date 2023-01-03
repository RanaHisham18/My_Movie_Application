package com.rana.mymovieapplication.di

import com.rana.mymovieapplication.data.remote.repository.MoviesRepository
import org.koin.core.qualifier.named
import org.koin.dsl.module

val moviesRepositoryModule = module {
    factory {
        MoviesRepository(
            nowPlayingService = get(),
            topRatedService = get(),
            popularService = get(),
            ioScheduler = get(named("io")),
            mainScheduler = get(named("main"))
        )
    }


}