package com.rana.mymovieapplication.app

import android.app.Application
import coil.Coil
import coil.ImageLoader
import coil.decode.SvgDecoder
import com.rana.mymovieapplication.di.moviesRepositoryModule
import com.rana.mymovieapplication.di.schedulerModule
import com.rana.mymovieapplication.di.serviceModule
import com.rana.mymovieapplication.di.viewmodelModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin


class Application : Application() {

    override fun onCreate() {
        super.onCreate()

//        val imageLoader = ImageLoader.Builder(this).componentRegistry {
//            add(SvgDecoder(this@Application))
//        }.build()
//
//        Coil.setImageLoader(imageLoader)
        startKoin {
            androidContext(this@Application)
            modules(
                listOf(
                    //here I should mention the app modules
                    viewmodelModules,
                    moviesRepositoryModule,
                    serviceModule,
                    schedulerModule
                )
            )
        }

        val imageLoader = ImageLoader.Builder(this).componentRegistry {
            add(SvgDecoder(this@Application))
        }.build()

        Coil.setImageLoader(imageLoader)
    }

}