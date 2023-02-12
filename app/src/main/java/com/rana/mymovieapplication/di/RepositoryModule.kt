package com.rana.mymovieapplication.di

import android.content.Context
import com.rana.mymovieapplication.data.remote.repository.MoviesRepository
import org.koin.android.ext.koin.androidApplication
import org.koin.core.qualifier.named
import org.koin.dsl.module

val moviesRepositoryModule = module {
    factory {
        MoviesRepository(
            nowPlayingService = get(),
            topRatedService = get(),
            popularService = get(),
            categoryService = get(),
            detailsService = get(),
            trailerService = get(),
            reviewsService = get(),
            castsService = get(),
            ioScheduler = get(named("io")),
            mainScheduler = get(named("main")),
            sharedPreferences = androidApplication().getSharedPreferences(
                "My Movie Application",
                Context.MODE_PRIVATE
            ))
    }


}