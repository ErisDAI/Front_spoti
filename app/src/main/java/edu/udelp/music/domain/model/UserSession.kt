package edu.udelp.music.domain.model

data class UserSession(
    val token: String,
    val username: String,
    val email: String
)
