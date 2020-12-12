package com.donaldinostroza.domain.entity

import java.util.Calendar

data class MovementEntity(var transactionDate : Calendar,
                     var type : TransactionType,
                     var amount: Long)
