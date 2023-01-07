package com.rana.mymovieapplication.di

import com.rana.mymovieapplication.BuildConfig
import com.rana.mymovieapplication.services.NowPlayingService
import com.rana.mymovieapplication.services.PopularService
import com.rana.mymovieapplication.services.TopRatedService
import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory
import org.koin.core.module.Module
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

val serviceModule = module {
        single {
          getRetrofit()
        }

        single {
           getRetrofit().create(NowPlayingService::class.java)
        }

        single {
           getRetrofit().create(TopRatedService::class.java)
        }

       single {
           getRetrofit().create(PopularService::class.java)
        }
    }

fun getRetrofit() =  Retrofit.Builder()
    .baseUrl(BuildConfig.API_BASE_URL)
    .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
    .addConverterFactory(MoshiConverterFactory.create())
    .build()


