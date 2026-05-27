package edu.udelp.music.ui.search

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import edu.udelp.music.data.remote.CatalogApi
import edu.udelp.music.data.remote.dto.ItemDto
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val api: CatalogApi
) : ViewModel() {

    private val _state = mutableStateOf(SearchState())
    val state: State<SearchState> = _state

    private var searchJob: Job? = null

    fun onQueryChange(query: String) {
        _state.value = _state.value.copy(query = query)
        searchJob?.cancel()
        searchJob = viewModelScope.launch {
            if (query.isBlank()) {
                _state.value = _state.value.copy(results = emptyList())
                return@launch
            }
            delay(500)
            _state.value = _state.value.copy(isLoading = true)
            try {
                val results = api.search(query)
                _state.value = _state.value.copy(results = results, isLoading = false)
            } catch (e: Exception) {
                _state.value = _state.value.copy(isLoading = false, error = "Error en búsqueda")
            }
        }
    }
}

data class SearchState(
    val query: String = "",
    val results: List<ItemDto> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null
)
