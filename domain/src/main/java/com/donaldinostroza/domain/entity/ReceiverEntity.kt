package com.donaldinostroza.domain.entity

import java.util.Calendar

open class ReceiverEntity {

    open fun getMonthlyExpense(monthlyMovements: List<MovementEntity>, month: Int, year: Int) : Long {
        return monthlyMovements
            .filter { it.transactionDate.get(Calendar.MONTH) == month && it.transactionDate.get(Calendar.YEAR) == year }
            .filter { it.type == TransactionType.OUTCOME }
            .sumOf { it.amount }
    }
}
