package com.donaldinostroza.domain.usecase

interface MonthlyExpensesUseCaseInputInterface {

    suspend fun get(receiverId: Int, month: Int)

}