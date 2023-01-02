package com.rana.mymovieapplication.di

import com.rana.mymovieapplication.services.NowPlayingService
import org.koin.core.module.Module
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.http.GET

val serviceModule = module {
 factory {
    NowPlayingService
 }
}