package com.fire.stonks.data.mapper

import com.fire.stonks.data.local.CompanyListingEntity
import com.fire.stonks.data.remote.dto.CompanyInfoDto
import com.fire.stonks.domain.model.CompanyListing
import com.fire.stonks.domain.model.CompanyInfo

fun CompanyListingEntity.toCompanyListing(): CompanyListing{
    return CompanyListing(
        name = name,
        symbol = symbol,
        exchange = exchange
    )
}

fun CompanyListing.toCompanyListingEntity(): CompanyListingEntity {
    return CompanyListingEntity(
        name = name,
        symbol = symbol,
        exchange = exchange
    )
}

fun CompanyInfoDto.toCompanyInfo(): CompanyInfo {
    return CompanyInfo(
        symbol = symbol ?: "",
        description = description ?: "",
        name = name ?: "",
        country = country ?: "",
        industry = industry ?: ""
    )
}
