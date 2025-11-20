package com.fire.stonks.di

import com.fire.stonks.data.csv.CSVParser
import com.fire.stonks.data.csv.CompanyListingsParser
import com.fire.stonks.data.repository.StockRepository
import com.fire.stonks.domain.model.CompanyListing
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun bindCompanyListingsParser(
        companyListingsParser: CompanyListingsParser
    ): CSVParser<CompanyListing>


    @Binds
    @Singleton
    abstract fun bindStockRepository(
        stockRepository: StockRepository
    ): StockRepository



}