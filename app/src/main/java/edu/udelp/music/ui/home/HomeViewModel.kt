package edu.udelp.music.ui.home

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import edu.udelp.music.data.remote.CatalogApi
import edu.udelp.music.data.remote.dto.HomeContentDto
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    val api: CatalogApi // Cambiado a val public para acceso simplificado en pantallas secundarias
) : ViewModel() {

    private val _state = mutableStateOf(HomeState())
    val state: State<HomeState> = _state

    init {
        loadContent()
    }

    private fun loadContent() {
        viewModelScope.launch {
            _state.value = _state.value.copy(isLoading = true)
            try {
                val content = api.getHomeContent()
                _state.value = _state.value.copy(content = content, isLoading = false)
            } catch (e: Exception) {
                _state.value = _state.value.copy(isLoading = false, error = "Error al cargar catálogo")
            }
        }
    }
}

data class HomeState(
    val content: HomeContentDto? = null,
    val isLoading: Boolean = false,
    val error: String? = null
)
