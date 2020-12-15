package com.donaldinostroza.domain

import com.donaldinostroza.domain.entity.ReceiverEntity
import com.donaldinostroza.domain.repository.MovementsRepository
import com.donaldinostroza.domain.usecase.MonthlyExpensesUseCase
import com.donaldinostroza.domain.usecase.MonthlyExpensesUseCaseOutputInterface
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.times
import org.mockito.MockitoAnnotations
import java.util.Calendar

@RunWith(JUnit4::class)
class MonthlyExpensesUseCaseTest {

    private lateinit var monthlyExpensesUseCase: MonthlyExpensesUseCase
    @Mock
    private lateinit var outputInterface: MonthlyExpensesUseCaseOutputInterface
    @Mock
    private lateinit var repository: MovementsRepository
    @Mock
    private lateinit var receiverEntity: ReceiverEntity

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        monthlyExpensesUseCase = MonthlyExpensesUseCase(outputInterface, repository, receiverEntity)
    }

    @Test
    fun `given receiverIdAndMonth when getMonthlyExpensesIsCalled then outInterfaceIsCalled`() {
        // Given
        val receiverId = 1
        val month = Calendar.JUNE
        val year = 2020

        // When
        runBlocking { monthlyExpensesUseCase.get(receiverId, month, year) }

        // Then
        Mockito.verify(outputInterface, times(1)).returnMonthlyExpense(0L)
    }

    @Test
    fun `given receiverIdAndMonth when getMonthlyExpensesIsCalled then repositoryIsCalled`() {
        //Given
        val receiverId = 1
        val month = Calendar.JUNE
        val year = 2020
        Mockito.`when`(repository.getMovementsByReceiver(receiverId)).thenReturn(listOf())

        // When
        runBlocking { monthlyExpensesUseCase.get(receiverId, month, year) }

        // Then
        Mockito.verify(repository, times(1)).getMovementsByReceiver(receiverId)
    }

    @Test
    fun `given receiverIdAndMonth when getMonthlyExpensesIsCalled then entityIsCalled`() {
        //Given
        val receiverId = 1
        val month = Calendar.JUNE
        val year = 2020
        Mockito.`when`(repository.getMovementsByReceiver(receiverId)).thenReturn(listOf())

        // When
        runBlocking { monthlyExpensesUseCase.get(receiverId, month, year) }

        // Then
        Mockito.verify(receiverEntity, times(1)).getMonthlyExpense(listOf(), month, year)
    }
}