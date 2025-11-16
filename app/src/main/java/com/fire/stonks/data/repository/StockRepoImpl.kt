package com.fire.stonks.data.repository

import android.net.http.HttpException
import android.os.Build
import androidx.annotation.RequiresExtension
import com.fire.stonks.data.csv.CSVParser
import com.fire.stonks.data.csv.CompanyListingsParser
import com.fire.stonks.data.local.StockDatabase
import com.fire.stonks.data.remote.StockApi
import com.fire.stonks.data.mapper.toCompanyListing
import com.fire.stonks.data.mapper.toCompanyListingEntity
import com.fire.stonks.domain.model.CompanyInfo
import com.fire.stonks.domain.model.CompanyListing
import com.fire.stonks.domain.model.IntraDayInfo
import com.fire.stonks.ui.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class StockRepoImpl  @Inject constructor(
    private val api: StockApi,
    private val db : StockDatabase,
    val companyListingParser: CSVParser<CompanyListing>


): StockRepository{
    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)

    override suspend fun getCompanyListings(
        fetchFromRemote: Boolean,
        query: String
    ): Flow<Resource<List<CompanyListing>>> {
        return flow{
            emit(Resource.Loading(true))
            val dao = db.dao
            val localListings = dao.searchCompanyListing(query)
            emit(Resource.Success(
                data = localListings.map{it.toCompanyListing()}
            ))
            val isDbEmpty = localListings.isEmpty() && query.isBlank()
            val shouldJustLoadFromCache = !isDbEmpty && !fetchFromRemote
            if(shouldJustLoadFromCache){
                emit(Resource.Loading(false))
                return@flow
            }
            val remoteListings =  try {

                val response =  api.getListings()
               companyListingParser.parse(response.byteStream())    // CVSReader((InputStreamReader(response.byteStream()))

            }catch (e : IOException){
                e.printStackTrace()
                emit(Resource.Error("   error due to IO "))
                null}
//            }catch (e: HttpException){
//                e.printStackTrace()
//                emit(Resource.Error("   error due to data loading "))
//                null
//            }
            remoteListings?.let { listings ->
                emit(Resource.Success(
                    data = dao.searchCompanyListing("").map { it.toCompanyListing() }
                ))
                emit(Resource.Loading(false))
                dao.clearCompanyListings()
              dao.insertCompanyListings(
                listings.map { it.toCompanyListingEntity() }
               )
            }
        }
    }

    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    override suspend fun getIntraDayInfo(symbol: String): Resource<List<IntraDayInfo>> {
        return try {
            val response = api.getIntraDayInfo(symbol)
            val results =          IntraDayInfoParser.parse(response.byteStream())
            Resource.Success(results)
        } catch(e: IOException) {
            e.printStackTrace()
            Resource.Error(
                message = "Couldn't load intraday info"
            )

        }catch (e: HttpException){
            Resource.Error(
                message = "Couldn't load intraday info"
            )
        }
    }

    override suspend fun getCompanyInfo(symbol: String): Resource<CompanyInfo> {
        TODO("Not yet implemented")
    }


}