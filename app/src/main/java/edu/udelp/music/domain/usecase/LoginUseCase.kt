package edu.udelp.music.domain.usecase

import edu.udelp.music.domain.model.UserSession
import edu.udelp.music.domain.repository.AuthRepository
import javax.inject.Inject

class LoginUseCase @Inject constructor(
    private val repository: AuthRepository
) {
    suspend operator fun invoke(username: String, password: String): Result<UserSession> {
        if (username.isBlank() || password.isBlank()) {
            return Result.failure(IllegalArgumentException("Credenciales no pueden estar vacías"))
        }
        return repository.login(username, password)
    }
}
