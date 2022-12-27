package com.rana.mymovieapplication.di

import com.rana.mymovieapplication.data.remote.repository.MoviesRepository
import com.rana.mymovieapplication.presentation.homescreen.HomeViewModel
import com.rana.mymovieapplication.services.NowPlayingService
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

   val viewmodelModules = module {
   viewModel {
       HomeViewModel(moviesRepository = get())
   } }
   val moviesRepositoryModule = module {
   factory{
       MoviesRepository(nowPlayingService = get())
    }


}

