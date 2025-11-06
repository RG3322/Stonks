package com.fire.stonks.presentation.company_listings

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fire.stonks.data.repository.StockRepository
import com.fire.stonks.domain.model.CompanyListingsState
import com.fire.stonks.ui.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class CompanyListingsViewmodel @Inject constructor(


    private val repository : StockRepository



) : ViewModel()
{
    var state by mutableStateOf(CompanyListingsState())
    private var searchJob : Job? = null

    fun onEvent(event : CompanyListingsEvent)
    {
        when(event)
        {
            is CompanyListingsEvent.Refresh ->
            {
                getCompanyListings(fetchFromRemote = true)

            }


            is CompanyListingsEvent.OnSearchQueryChange ->{
                state = state.copy(searchQuery = event.query)
                searchJob?.cancel()
                searchJob = viewModelScope.launch {
                    delay(500L)
                    getCompanyListings()
                }

            }

           // else -> {

           // }
        }
        }

    fun getCompanyListings(
        query : String = state.searchQuery.lowercase(),
        fetchFromRemote : Boolean = false
    ){

        viewModelScope.launch {
            repository
                .getCompanyListings(fetchFromRemote,query)
                .collect {
                    result ->
                    when(result) {
                        is Resource.Error<*> -> TODO()
                        is Resource.Loading<*> ->{state = state.copy(isLoading = result.isLoading)}
                        is Resource.Success<*> -> TODO()
                    }


                }
        }

    }




}