package com.rana.mymovieapplication.di

import com.rana.mymovieapplication.data.remote.repos.MoviesRepo
import com.rana.mymovieapplication.presentation.homescreen.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val viewmodelModules = module {
    viewModel {
        HomeViewModel(repo = get())
    }
}

val repoModule = module {
    factory {
        MoviesRepo(moviesServices = get())
    }
}

