package com.donaldinostroza.domain.repository

import com.donaldinostroza.domain.entity.MovementEntity

interface MovementsRepository {

    fun getMovementsByReceiver(receiverId: Int) : List<MovementEntity>
}