package edu.udelp.music.data.remote.dto

data class RegisterRequest(
    val username: String,
    val email: String,
    val password: String
)
