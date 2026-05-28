package edu.udelp.music.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import edu.udelp.music.data.remote.CatalogApi
import edu.udelp.music.data.remote.dto.HomeContentDto
import edu.udelp.music.presentation.viewmodel.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    val api: CatalogApi
) : ViewModel() {

    private val _uiState = MutableStateFlow<UiState<HomeContentDto>>(UiState.Loading)
    val uiState: StateFlow<UiState<HomeContentDto>> = _uiState.asStateFlow()

    init {
        loadContent()
    }

    fun loadContent() {
        viewModelScope.launch {
            _uiState.value = UiState.Loading
            try {
                val content = api.getHomeContent()
                if (content.sections.isEmpty()) {
                    _uiState.value = UiState.Empty
                } else {
                    _uiState.value = UiState.Success(content)
                }
            } catch (e: Exception) {
                _uiState.value = UiState.Error("Error al cargar el catálogo")
            }
        }
    }
}
