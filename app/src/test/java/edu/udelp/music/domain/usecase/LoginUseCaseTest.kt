package edu.udelp.music.domain.usecase

import edu.udelp.music.domain.model.UserSession
import edu.udelp.music.domain.repository.AuthRepository
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations

class LoginUseCaseTest {

    @Mock
    private lateinit var repository: AuthRepository

    private lateinit var loginUseCase: LoginUseCase

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        loginUseCase = LoginUseCase(repository)
    }

    @Test
    fun `invoke with empty credentials returns failure`() = runBlocking {
        val result = loginUseCase("", "")
        assertTrue(result.isFailure)
    }

    @Test
    fun `invoke with valid credentials returns success`() = runBlocking {
        val session = UserSession("token", "user", "test@test.com")
        `when`(repository.login("user", "pass")).thenReturn(Result.success(session))
        
        val result = loginUseCase("user", "pass")
        assertTrue(result.isSuccess)
    }
}
