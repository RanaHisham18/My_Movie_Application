package com.rana.mymovieapplication.network

import com.rana.mymovieapplication.BuildConfig
import com.squareup.moshi.Moshi
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.lang.ref.Cleaner.create

class ApplicationNetwork private constructor(private val retrofit : Retrofit) {

    companion object {
        private lateinit var retrofit: Retrofit

        private lateinit var instance: ApplicationNetwork

        fun newInstance(baseUrl :String = BuildConfig.API_BASE_URL): ApplicationNetwork{
            if (this::retrofit.isInitialized.not())
                retrofit = Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(MoshiConverterFactory.create())
                    .build()
            if (this::instance.isInitialized.not())
                instance = ApplicationNetwork(this.retrofit)
            return instance
        }
    }

    fun <T : Any> createService(clazz: Class<T>): T = retrofit.create(clazz)
}