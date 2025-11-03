package com.fire.stonks.data.repository

import com.fire.stonks.domain.model.CompanyListing
import com.fire.stonks.ui.util.Resource
import kotlinx.coroutines.flow.Flow

interface StockRepository{


    suspend fun getCompanyListings(
        fetchFromRemote: Boolean,
        query: String
    ): Flow<Resource<List<CompanyListing>>>



}