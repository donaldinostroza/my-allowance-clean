package com.donaldinostroza.domain.usecase

import java.time.Month

internal class GetMonthlyExpensesUseCase(
    private val outputInterface: GetMonthlyExpensesUseCaseOutputInterface
) : GetMonthlyExpensesUseCaseInputInterface {

    override fun get(receiverId: Int, month: Month) {
        outputInterface.returnMonthlyExpense(1000L)
    }
}