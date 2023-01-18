package com.rana.mymovieapplication.di

import com.rana.mymovieapplication.BuildConfig
import com.rana.mymovieapplication.services.MovieCategoryService
import com.rana.mymovieapplication.services.NowPlayingService
import com.rana.mymovieapplication.services.PopularService
import com.rana.mymovieapplication.services.TopRatedService
import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

val serviceModule = module {

    single {
        Retrofit.Builder()
            .baseUrl(BuildConfig.API_BASE_URL)
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
    }

    factory {
        get<Retrofit>().create(NowPlayingService::class.java)
    }

    factory {
        get<Retrofit>().create(TopRatedService::class.java)
    }

    factory {
        get<Retrofit>().create(PopularService::class.java)
    }

    factory {
        get<Retrofit>().create(MovieCategoryService::class.java)
    }
}