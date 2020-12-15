package com.donaldinostroza.myallowanceclean.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.donaldinostroza.domain.usecase.MonthlyExpensesUseCaseInputInterface
import com.donaldinostroza.domain.usecase.MonthlyExpensesUseCaseOutputInterface
import com.donaldinostroza.myallowanceclean.ui.main.di.UseCaseFactory
import com.donaldinostroza.myallowanceclean.ui.main.di.RepositoryFactory
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.text.NumberFormat
import java.util.Calendar
import java.util.Currency
import java.util.Locale

class ReceiverProfileViewModel : ViewModel(), MonthlyExpensesUseCaseOutputInterface {

    var monthlyExpense: String = ""

    private val monthlyExpensesUseCase: MonthlyExpensesUseCaseInputInterface =
        UseCaseFactory.getMonthlyExpensesUseCase(this, RepositoryFactory.getMovementsRepository())

    fun initData() {
        viewModelScope.launch(Dispatchers.IO) {
            monthlyExpensesUseCase.get(1, Calendar.DECEMBER)
        }
    }

    override fun returnMonthlyExpense(value: Long) {
        monthlyExpense = formatAmount(value)
    }

    private fun formatAmount(value: Long) : String {
        val nf = NumberFormat.getInstance()
        nf.isGroupingUsed = true
        val currency = Currency.getInstance(Locale.getDefault())
        nf.currency = currency

        return currency.symbol +  NumberFormat.getInstance().format(value)
    }

}
