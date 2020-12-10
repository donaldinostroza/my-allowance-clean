package com.donaldinostroza.domain.usecase

import java.time.Month

interface GetMonthlyExpensesUseCaseInputInterface {

    fun get(receiverId: Int, month: Month)

}