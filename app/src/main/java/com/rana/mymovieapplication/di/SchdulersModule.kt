package com.rana.mymovieapplication.di

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.schedulers.Schedulers
import org.koin.core.qualifier.named
import org.koin.dsl.module

val schedulerModule = module {

    single(named("io")) {
        Schedulers.io()
    }

    single(named("main")) {
        AndroidSchedulers.mainThread()
    }
}