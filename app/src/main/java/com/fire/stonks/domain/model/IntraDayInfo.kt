package com.fire.stonks.domain.model

import java.time.LocalDateTime

data class IntraDayInfo(
    val date: LocalDateTime?,
//    val open: Double,
//    val high: Double,
//    val low: Double,
    val close: Double
)
