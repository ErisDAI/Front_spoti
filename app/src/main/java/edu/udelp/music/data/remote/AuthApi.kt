package edu.udelp.music.data.remote

import edu.udelp.music.data.remote.dto.AuthResponse
import edu.udelp.music.data.remote.dto.LoginRequest
import retrofit2.http.Body
import retrofit2.http.POST

import edu.udelp.music.data.remote.dto.RegisterRequest

interface AuthApi {
    @POST("api/v1/auth/login")
    suspend fun login(@Body request: LoginRequest): AuthResponse

    @POST("api/v1/users/register")
    suspend fun register(@Body request: RegisterRequest): AuthResponse
}
