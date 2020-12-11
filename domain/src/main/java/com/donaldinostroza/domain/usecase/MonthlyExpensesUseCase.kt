package com.donaldinostroza.domain.usecase

internal class MonthlyExpensesUseCase(
    private val outputInterface: MonthlyExpensesUseCaseOutputInterface
) : MonthlyExpensesUseCaseInputInterface {

    override suspend fun get(receiverId: Int, month: Int) {
        outputInterface.returnMonthlyExpense(1000L)
    }
}