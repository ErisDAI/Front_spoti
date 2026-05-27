package edu.udelp.music.domain.usecase

import edu.udelp.music.domain.model.UserSession
import edu.udelp.music.domain.repository.AuthRepository
import javax.inject.Inject

class RegisterUseCase @Inject constructor(
    private val repository: AuthRepository
) {
    suspend operator fun invoke(username: String, email: String, password: String): Result<UserSession> {
        if (username.isBlank() || email.isBlank() || password.isBlank()) {
            return Result.failure(IllegalArgumentException("Campos obligatorios"))
        }
        return repository.register(username, email, password)
    }
}
