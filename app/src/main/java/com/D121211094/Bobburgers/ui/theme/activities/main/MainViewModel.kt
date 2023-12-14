package com.D121211094.Bobburgers.ui.theme.activities.main

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.D121211094.Bobburgers.MyApplication
import com.D121211094.Bobburgers.data.models.Character
import com.D121211094.Bobburgers.data.repository.CharRepository
import kotlinx.coroutines.launch
import java.io.IOException

sealed interface MainUiState {
    data class Success(val data: List<Character>) : MainUiState
    object Error : MainUiState
    object Loading : MainUiState
}

class MainViewModel(private val charRepository: CharRepository): ViewModel() {

    var mainUiState: MainUiState by mutableStateOf(MainUiState.Loading)
        private set

    fun getChar() = viewModelScope.launch {
        mainUiState = MainUiState.Loading
        try {
            val result = charRepository.getChar()
            Log.d("MainViewModel", "getChar: ${result.size}")
            mainUiState = MainUiState.Success(result.orEmpty())
        } catch (e: IOException) {
            Log.d("MainViewMode", "getChar error: ${e.message}")
            mainUiState = MainUiState.Error
        }
    }

    init {
        getChar()
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as MyApplication)
                val charRepository = application.container.charRepository
                MainViewModel(charRepository)
            }
        }
    }

}