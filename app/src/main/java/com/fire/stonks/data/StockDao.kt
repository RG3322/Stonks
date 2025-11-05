package com.fire.stonks.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.fire.stonks.data.local.CompanyListingEntity

@Dao
interface StockDao {
    @Insert(onConflict = OnConflictStrategy.Companion.REPLACE)
    suspend fun insertCompanyEntities(
        companyListingEntities:List<CompanyListingEntity>
    )
    @Query("DELETE FROM companylistingentity")
    suspend fun clearCompanyListings()

    @Query("""
        SELECT *
        FROM companylistingentity
        WHERE LOWER(name) LIKE '%' || LOWER(:query) || '%' OR UPPER(:query) = symbol
    """)
    suspend fun searchCompanyListing(query:String):List<CompanyListingEntity>
    fun insertCompanyListings(map: kotlin.collections.List<com.fire.stonks.data.local.CompanyListingEntity>)


}
// * We use """ to write multiline string in kotlin and to use in creating complex queries in room
//