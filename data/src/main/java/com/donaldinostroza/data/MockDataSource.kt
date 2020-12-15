package com.donaldinostroza.data

import com.donaldinostroza.domain.entity.MovementEntity
import com.donaldinostroza.domain.entity.TransactionType
import com.donaldinostroza.domain.repository.MovementsRepository
import java.util.*

class MockDataSource : MovementsRepository {
    override fun getMovementsByReceiver(receiverId: Int) : List<MovementEntity> {
        return getSampleMovements()
    }

    private fun getSampleMovements() : List<MovementEntity> {
        return listOf(
            MovementEntity(GregorianCalendar(2019,Calendar.APRIL,1), TransactionType.OUTCOME, 2800),
            MovementEntity(GregorianCalendar(2019,Calendar.AUGUST,1), TransactionType.INCOME, 5500),
            MovementEntity(GregorianCalendar(2019,Calendar.DECEMBER,1), TransactionType.OUTCOME, 5500),
            MovementEntity(GregorianCalendar(2020,Calendar.MARCH,1), TransactionType.OUTCOME, 4200),
            MovementEntity(GregorianCalendar(2020,Calendar.JUNE,1), TransactionType.INCOME, 4500),
            MovementEntity(GregorianCalendar(2020,Calendar.SEPTEMBER,1), TransactionType.OUTCOME, 1500),
            MovementEntity(GregorianCalendar(2020,Calendar.DECEMBER,1), TransactionType.INCOME, 10000),
            MovementEntity(GregorianCalendar(2020,Calendar.DECEMBER,5), TransactionType.OUTCOME, 3500),
            MovementEntity(GregorianCalendar(2020,Calendar.DECEMBER,12), TransactionType.OUTCOME, 4000),
            MovementEntity(GregorianCalendar(2020,Calendar.DECEMBER,8), TransactionType.OUTCOME, 1000)
        )
    }

}