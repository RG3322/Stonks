package com.fire.stonks.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.fire.stonks.data.StockDao

@Database(
    entities = [CompanyListingEntity::class],
    version = 1,
    exportSchema = false
)
 abstract class StockDatabase: RoomDatabase() {
    abstract val dao: StockDao
}