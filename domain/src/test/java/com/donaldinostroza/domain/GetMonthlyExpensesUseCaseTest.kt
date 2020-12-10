package com.donaldinostroza.domain

import com.donaldinostroza.domain.usecase.GetMonthlyExpensesUseCase
import com.donaldinostroza.domain.usecase.GetMonthlyExpensesUseCaseOutputInterface
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.ArgumentMatchers.eq
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.times
import org.mockito.MockitoAnnotations
import java.time.Month

@RunWith(JUnit4::class)
class GetMonthlyExpensesUseCaseTest {

    private lateinit var getMonthlyExpensesUseCase: GetMonthlyExpensesUseCase
    @Mock
    private lateinit var outputInterface: GetMonthlyExpensesUseCaseOutputInterface

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        getMonthlyExpensesUseCase = GetMonthlyExpensesUseCase(outputInterface)
    }

    @Test
    fun `given receiverIdAndMonth when getMonthlyExpensesIsCalled then returnsAValidResponse`() {
        // Given
        val receiverId = 1
        val month = Month.JUNE

        // When
        val response = getMonthlyExpensesUseCase.get(receiverId, month)

        // Then
        Mockito.verify(outputInterface, times(1)).returnMonthlyExpense(eq(1000L))
    }
}