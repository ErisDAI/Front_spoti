package edu.udelp.music.ui.account

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import edu.udelp.music.data.remote.AuthApi
import edu.udelp.music.data.remote.dto.AuthResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AccountViewModel @Inject constructor(
    private val api: AuthApi
) : ViewModel() {

    private val _state = mutableStateOf(AccountState())
    val state: State<AccountState> = _state

    init {
        loadProfile()
    }

    private fun loadProfile() {
        viewModelScope.launch {
            _state.value = _state.value.copy(isLoading = true)
            try {
                // En un flujo real usaríamos el endpoint /account/me
                // Por ahora simulamos la respuesta basada en el usuario logueado
                _state.value = _state.value.copy(
                    username = "user_test",
                    email = "test@udelp.edu",
                    isLoading = false
                )
            } catch (e: Exception) {
                _state.value = _state.value.copy(isLoading = false, error = "No se pudo cargar el perfil")
            }
        }
    }
}

data class AccountState(
    val username: String = "",
    val email: String = "",
    val isLoading: Boolean = false,
    val error: String? = null
)
