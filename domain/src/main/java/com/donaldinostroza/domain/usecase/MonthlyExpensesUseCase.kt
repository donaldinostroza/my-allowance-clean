package com.donaldinostroza.domain.usecase

import com.donaldinostroza.domain.entity.ReceiverEntity
import com.donaldinostroza.domain.repository.MovementsRepository

class MonthlyExpensesUseCase(
    private val outputInterface: MonthlyExpensesUseCaseOutputInterface,
    private val movementsRepository: MovementsRepository,
    private val receiverEntity: ReceiverEntity
) : MonthlyExpensesUseCaseInputInterface {

    override suspend fun get(receiverId: Int, month: Int, year: Int) {
        val movements = movementsRepository.getMovementsByReceiver(receiverId)
        val amount = receiverEntity.getMonthlyExpense(movements, month, year)

        outputInterface.returnMonthlyExpense(amount)
    }
}