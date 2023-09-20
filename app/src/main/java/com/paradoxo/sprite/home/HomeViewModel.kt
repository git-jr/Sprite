package com.paradoxo.sprite.home

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class HomeViewModel() : ViewModel() {

    private val _uiState = MutableStateFlow(HomeState())
    var uiState = _uiState.asStateFlow()

    fun changeCorner() {
        _uiState.value = _uiState.value.copy(
            changeCorner = !_uiState.value.changeCorner
        )
    }

    fun changeMoveCard() {
        _uiState.value = _uiState.value.copy(
            moveCard = !_uiState.value.moveCard
        )
    }
}