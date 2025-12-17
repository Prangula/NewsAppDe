package com.newsappde.presentation.ui.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.newsappde.domain.use_case.NewsUseCase
import com.newsappde.presentation.state.NewsState
import com.newsappde.utils.extensions.viewModelScope
import com.newsappde.utils.resource.Resource

class NewsVm(
    private val newsUseCase: NewsUseCase
) : ViewModel() {

    var state by mutableStateOf(NewsState())
        private set

    init {
        getNews()
    }

    private fun getNews() {
        viewModelScope {
            state = state.copy(
                isLoading = true,
                errorMessage = null
            )
            when (val result = newsUseCase.invoke()) {
                is Resource.Success -> {
                    state = state.copy(
                        newsList = result.data,
                        isLoading = false,
                        errorMessage = null
                    )
                }

                is Resource.Error -> {
                    state = state.copy(
                        newsList = null,
                        isLoading = false,
                        errorMessage = result.message
                    )
                }
            }
        }
    }
}