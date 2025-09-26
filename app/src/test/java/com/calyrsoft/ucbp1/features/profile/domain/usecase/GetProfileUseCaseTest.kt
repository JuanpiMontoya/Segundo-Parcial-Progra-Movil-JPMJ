package com.calyrsoft.ucbp1.features.profile.domain.usecase

import com.calyrsoft.ucbp1.features.profile.data.repository.FakeProfileRepository
import kotlinx.coroutines.test.runTest
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class GetProfileUseCaseTest {
    @Test
    fun `GetProfileUseCase debe devolver ProfileModel correctamente`() = runTest {
        val repository = FakeProfileRepository()
        val useCase = GetProfileUseCase(repository)
        val result = useCase.invoke()
        assertTrue(result.isSuccess)
        assertEquals("Sara Montenegro", result.getOrThrow().name.value)
    }
}