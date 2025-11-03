package com.fire.stonks.data.repository

import android.net.http.HttpException
import androidx.collection.emptyObjectList
import com.fire.stonks.data.local.StockDatabase
import com.fire.stonks.data.remote.StockApi
import com.fire.stonks.data.toCompanyListing
import com.fire.stonks.domain.model.CompanyListing
import com.fire.stonks.ui.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException
import java.io.InputStreamReader
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class StockRepoImpl  @Inject constructor(
    val api: StockApi,
    private val db : StockDatabase
): StockRepository{
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
                response.byteStream()
                val csvReader = (InputStreamReader(response.byteStream()))    // CVSReader((InputStreamReader(response.byteStream()))

            }catch (e : IOException){
                e.printStackTrace()
                emit(Resource.Error("   error due to IO "))
            }catch (e: HttpException){
                e.printStackTrace()
                emit(Resource.Error("   error due to data loading "))
            }
        }
    }


}