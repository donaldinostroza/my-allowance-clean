package com.donaldinostroza.domain.usecase

//TODO validate this approach instead of using Hilt
class UseCaseFactory {
    companion object {
        fun getMonthlyExpensesUseCase(outputInterface: MonthlyExpensesUseCaseOutputInterface)
                : MonthlyExpensesUseCaseInputInterface {
            return MonthlyExpensesUseCase(outputInterface)
        }
    }
}