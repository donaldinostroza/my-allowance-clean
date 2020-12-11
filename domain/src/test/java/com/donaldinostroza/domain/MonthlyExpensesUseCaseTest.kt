package com.donaldinostroza.domain

import com.donaldinostroza.domain.usecase.MonthlyExpensesUseCase
import com.donaldinostroza.domain.usecase.MonthlyExpensesUseCaseOutputInterface
import kotlinx.coroutines.runBlocking
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
class MonthlyExpensesUseCaseTest {

    private lateinit var monthlyExpensesUseCase: MonthlyExpensesUseCase
    @Mock
    private lateinit var outputInterface: MonthlyExpensesUseCaseOutputInterface

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        monthlyExpensesUseCase = MonthlyExpensesUseCase(outputInterface)
    }

    @Test
    fun `given receiverIdAndMonth when getMonthlyExpensesIsCalled then returnsAValidResponse`() {
        // Given
        val receiverId = 1
        val month = Month.JUNE

        // When
        runBlocking { monthlyExpensesUseCase.get(receiverId, month) }

        // Then
        Mockito.verify(outputInterface, times(1)).returnMonthlyExpense(eq(1000L))
    }
}