package com.donaldinostroza.myallowanceclean.ui.main.di

import com.donaldinostroza.domain.entity.ReceiverEntity
import com.donaldinostroza.domain.repository.MovementsRepository
import com.donaldinostroza.domain.usecase.MonthlyExpensesUseCase
import com.donaldinostroza.domain.usecase.MonthlyExpensesUseCaseInputInterface
import com.donaldinostroza.domain.usecase.MonthlyExpensesUseCaseOutputInterface

class UseCaseFactory {
    companion object {
        fun getMonthlyExpensesUseCase(
            outputInterface: MonthlyExpensesUseCaseOutputInterface,
            movementsRepository: MovementsRepository): MonthlyExpensesUseCaseInputInterface {
            return MonthlyExpensesUseCase(outputInterface, movementsRepository, ReceiverEntity())
        }
    }
}