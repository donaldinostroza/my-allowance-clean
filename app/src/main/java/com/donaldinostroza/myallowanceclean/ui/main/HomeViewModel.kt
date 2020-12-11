package com.donaldinostroza.myallowanceclean.ui.main

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.donaldinostroza.domain.usecase.MonthlyExpensesUseCaseInputInterface
import com.donaldinostroza.domain.usecase.MonthlyExpensesUseCaseOutputInterface
import com.donaldinostroza.domain.usecase.UseCaseFactory
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.*

class HomeViewModel @ViewModelInject constructor()
    : ViewModel(), MonthlyExpensesUseCaseOutputInterface {

    var monthlyExpense: String = ""

    private val monthlyExpensesUseCase: MonthlyExpensesUseCaseInputInterface = UseCaseFactory.getMonthlyExpensesUseCase(this)

    fun initData() {
        viewModelScope.launch(Dispatchers.IO) {
            monthlyExpensesUseCase.get(1, Calendar.DECEMBER)
        }
    }

    override fun returnMonthlyExpense(value: Long) {
        monthlyExpense = value.toString()
    }

}
