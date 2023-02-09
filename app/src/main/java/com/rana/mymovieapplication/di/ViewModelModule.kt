package com.rana.mymovieapplication.di

import com.rana.mymovieapplication.presentation.homescreen.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

   val viewmodelModules = module {
   viewModel {
       HomeViewModel(moviesRepository = get())
   } }





