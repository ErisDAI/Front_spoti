package edu.udelp.music.domain.usecase

import edu.udelp.music.domain.repository.AuthRepository
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations

class RegisterUseCaseTest {

    @Mock
    private lateinit var repository: AuthRepository

    private lateinit var registerUseCase: RegisterUseCase

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        registerUseCase = RegisterUseCase(repository)
    }

    @Test
    fun `invoke with empty fields returns failure`() = runBlocking {
        val result = registerUseCase("", "", "")
        assertTrue(result.isFailure)
    }

    @Test
    fun `invoke with valid data returns success`() = runBlocking {
        `when`(repository.register("user", "email@test.com", "pass"))
            .thenReturn(Result.success(Unit))
        
        val result = registerUseCase("user", "email@test.com", "pass")
        assertTrue(result.isSuccess)
    }
}
