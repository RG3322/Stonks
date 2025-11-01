package com.fire.stonks.data.repository

import com.fire.stonks.domain.model.CompanyListing

interface StockRepository{


    suspend fun getCompanyListings()



}