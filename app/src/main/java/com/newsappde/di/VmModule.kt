package com.newsappde.di

import com.newsappde.presentation.vm.NewsVm
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val vmModule = module {
    viewModel { NewsVm(newsUseCase = get()) }
}