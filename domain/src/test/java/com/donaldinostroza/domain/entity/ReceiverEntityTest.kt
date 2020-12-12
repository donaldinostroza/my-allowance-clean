package com.donaldinostroza.domain.entity

import junit.framework.Assert.assertEquals
import junit.framework.TestCase
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import java.util.*

@RunWith(JUnit4::class)
class ReceiverEntityTest {
    private lateinit var entity: ReceiverEntity

    @Before
    fun setUp() {
        entity = ReceiverEntity()
    }

    @Test
    fun `given movementsAndMonth when getMonthlyExpenseIsCalled then returnsTheRightValue`() {
        //Given
        val movements = listOf (
            MovementEntity(GregorianCalendar(2020, Calendar.DECEMBER, 1), TransactionType.OUTCOME, 1000),
            MovementEntity(GregorianCalendar(2020, Calendar.DECEMBER, 2), TransactionType.OUTCOME, 2000),
            MovementEntity(GregorianCalendar(2020, Calendar.DECEMBER, 3), TransactionType.OUTCOME, 3000),
        )
        val month = Calendar.DECEMBER
        val expectedValue = 6000L

        //When
        val result = entity.getMonthlyExpense(movements, month)

        //Then
        assertEquals(expectedValue, result)
    }

    @Test
    fun `given emptyMovements when getMonthlyExpenseIsCalled then returnsZero`() {
        //Given
        val movements = listOf<MovementEntity>()
        val month = Calendar.DECEMBER
        val expectedValue = 0L

        //When
        val result = entity.getMonthlyExpense(movements, month)

        //Then
        assertEquals(expectedValue, result)
    }

}