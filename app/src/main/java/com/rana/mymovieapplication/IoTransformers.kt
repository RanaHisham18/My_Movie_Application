package com.rana.mymovieapplication

import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.core.SingleSource
import io.reactivex.rxjava3.core.SingleTransformer
import org.koin.core.component.KoinComponent
import org.koin.core.component.get
import org.koin.core.qualifier.named

class IoTransformers <T : Any> : SingleTransformer<T, T>, KoinComponent {

    private val ioThread = get<Scheduler> (named("io"))
    private val mainThread = get <Scheduler>(named("main"))
    override fun apply(upstream: Single<T>): SingleSource<T> = upstream

            .subscribeOn(ioThread)
            .observeOn(mainThread)
    }
