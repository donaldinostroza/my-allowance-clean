package com.donaldinostroza.domain.entity

import java.util.Calendar

open class ReceiverEntity {

    fun getMonthlyExpense(monthlyMovements: List<MovementEntity>, month: Int) : Long {
        return monthlyMovements
            .filter { it.transactionDate.get(Calendar.MONTH) == month }
            .filter { it.type == TransactionType.OUTCOME }
            .sumOf { it.amount }
    }
}
