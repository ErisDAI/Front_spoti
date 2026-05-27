package edu.udelp.music.domain.repository

import edu.udelp.music.domain.model.UserSession

interface AuthRepository {
    suspend fun login(username: String, password: String): Result<UserSession>
    suspend fun register(username: String, email: String, password: String): Result<UserSession>
}
