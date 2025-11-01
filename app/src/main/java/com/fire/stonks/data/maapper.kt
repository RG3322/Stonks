package com.fire.stonks.data

import com.fire.stonks.data.local.CompanyListingEntity
import com.fire.stonks.domain.model.CompanyListing

fun CompanyListingEntity.toCompanyListing(): CompanyListing{
    return CompanyListing(
        name = name,
        symbol,
        exchange
    )
}


fun CompanyListingEntity.toCompanyListingEntity(): CompanyListingEntity{
    return CompanyListingEntity(
        name = name,
        symbol,
        exchange
    )
}
