package edu.udelp.music.data.repository

import edu.udelp.music.data.remote.AuthApi
import edu.udelp.music.data.remote.dto.LoginRequest
import edu.udelp.music.domain.model.UserSession
import edu.udelp.music.domain.repository.AuthRepository
import javax.inject.Inject

import edu.udelp.music.data.remote.dto.RegisterRequest

import org.json.JSONObject
import retrofit2.HttpException

import edu.udelp.music.data.local.SessionManager

class AuthRepositoryImpl @Inject constructor(
    private val api: AuthApi,
    private val sessionManager: SessionManager
) : AuthRepository {
    override suspend fun login(username: String, password: String): Result<UserSession> {
        return try {
            val response = api.login(LoginRequest(username, password))
            sessionManager.saveToken(response.token)
            Result.success(
                UserSession(
                    token = response.token,
                    username = response.username,
                    email = response.email
                )
            )
        } catch (e: HttpException) {
            val errorMsg = try {
                val json = JSONObject(e.response()?.errorBody()?.string() ?: "")
                json.getString("message")
            } catch (inner: Exception) {
                "Error en la autenticación"
            }
            Result.failure(Exception(errorMsg))
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override suspend fun register(
        username: String,
        email: String,
        password: String
    ): Result<UserSession> {
        return try {
            val response = api.register(RegisterRequest(username, email, password))
            Result.success(
                UserSession(
                    token = response.token,
                    username = response.username,
                    email = response.email
                )
            )
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}
