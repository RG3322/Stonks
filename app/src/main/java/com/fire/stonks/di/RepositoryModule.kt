package com.fire.stonks.di

import com.fire.stonks.data.csv.CSVParser
import com.fire.stonks.data.csv.companyListingsParser
import com.fire.stonks.data.repository.StockRepository
import com.fire.stonks.domain.model.CompanyListing
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import javax.inject.Singleton


@Module
@InstallIn(Singleton::class)
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun bindCompanyListingsParser(
        companyListingsParser: companyListingsParser
    ): CSVParser<CompanyListing>


    @Binds
    @Singleton
    abstract fun bindStockRepository(
        stockRepository: StockRepository
    ): StockRepository



}