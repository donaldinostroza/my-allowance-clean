package com.donaldinostroza.myallowanceclean.ui.main.di

import com.donaldinostroza.data.MockDataSource
import com.donaldinostroza.domain.repository.MovementsRepository

class RepositoryFactory {
    companion object {
        fun getMovementsRepository() : MovementsRepository
        {
            return MockDataSource()
        }
    }
}