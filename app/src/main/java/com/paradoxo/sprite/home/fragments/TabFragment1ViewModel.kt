package com.paradoxo.sprite.home.fragments

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class TabFragment1ViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(Fragment1State())
    val uiState = _uiState.asStateFlow()

    fun setHeightScreen(height: Int) {
        _uiState.value = _uiState.value.copy(
            heighScreen = height / 2
        )
    }

}


data class Fragment1State(
    val cornerRadius: Float = 0f,
    val heighScreen: Int = 100
)