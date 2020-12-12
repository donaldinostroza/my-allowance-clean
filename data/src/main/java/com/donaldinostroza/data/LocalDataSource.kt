package com.donaldinostroza.data

import com.donaldinostroza.domain.entity.MovementEntity
import com.donaldinostroza.domain.repository.MovementsRepository

class LocalDataSource : MovementsRepository {
    override fun getMovementsByReceiver(receiverId: Int) : List<MovementEntity> {
        return listOf<MovementEntity>()
    }

}