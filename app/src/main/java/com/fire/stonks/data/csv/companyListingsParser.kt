package com.fire.stonks.data.csv

import com.fire.stonks.domain.model.CompanyListing
import java.io.InputStream
import java.io.InputStreamReader
import javax.inject.Inject
import javax.inject.Singleton
import com.opencsv.CSVReader
//import org.apache.commons.csv.CSVParser
//import org.apache.commons.csv.CSVFormat




@Singleton
class companyListingsParser @Inject constructor() : CSVParser<CompanyListing> {
    override suspend fun parse(stream: InputStream): List<CompanyListing> {
        val csvReader = CSVReader(InputStreamReader(stream))
        return csvReader
            .readAll()
            .drop(1)
            .mapNotNull { line ->
                val symbol = line.getOrNull(0)
                val name = line.getOrNull(1)
                val exchange = line.getOrNull(2)
                CompanyListing(
                    name = name ?: return@mapNotNull null,
                    symbol = symbol ?: return@mapNotNull null,
                    exchange = exchange ?: return@mapNotNull null
                )
            }
            .also{
                csvReader.close()

            }
    }
}