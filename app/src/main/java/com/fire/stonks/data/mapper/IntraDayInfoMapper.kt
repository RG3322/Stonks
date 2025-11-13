package com.fire.stonks.data.mapper

import com.fire.stonks.data.remote.dto.IntraDayInfoDto
import com.fire.stonks.domain.model.IntraDayInfo
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.Locale

fun IntraDayInfoDto.toIntraDayInfo(): IntraDayInfo {
    val pattern = "yyyy-MM-dd HH:mm:ss"
    val formatter = DateTimeFormatter.ofPattern(pattern,Locale.getDefault())
    val localDateTime = LocalDateTime.parse(timestamp,formatter)

    return IntraDayInfo(
        date = localDateTime,
        close = close
    )
}
