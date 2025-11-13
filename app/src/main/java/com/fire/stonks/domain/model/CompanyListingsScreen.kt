package com.fire.stonks.domain.model

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
//simport com.fire.stonks.presentation.company_listings.CompanyItem
import com.fire.stonks.presentation.company_listings.CompanyListingsEvent
import com.fire.stonks.presentation.company_listings.CompanyListingsViewmodel


//@Composable
//fun CompanyListingsScreen() {
//    val viewModel: CompanyListingsViewModel = hiltViewModel()
//    val state = viewModel.state
//
//    val swipeRefreshState = rememberSwipeRefreshState(
//        isRefreshing = state.isRefreshing
//    )
//
//    SwipeRefresh(
//        state = swipeRefreshState,
//        onRefresh = {
//            viewModel.onEvent(CompanyListingsEvent.Refresh)
//        }
//    ) {
//        // add the Column here   @
//    }
//}
@Composable
fun CompanyListingsScreen(navController: NavController){
    val viewModel: CompanyListingsViewmodel = hiltViewModel()
    val state = viewModel.state
    Column(modifier = Modifier.fillMaxSize()){//this code to be added at @

        OutlinedTextField(
            value = state.searchQuery, //value = state.searchQuery
            onValueChange = {
                viewModel.onEvent(CompanyListingsEvent.OnSearchQueryChange(it))
            },//onValueChange   =  viewmodel.onEvent(CompanyListingsEvent.OnSearchQueryChange(it)
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            placeholder = {Text (text = " Search...?")},
            maxLines = 1,
            singleLine = true

        )
       // SwipeRefresh(state = , onRefresh = {viewModel.onEvent(CompanyListingsEvent.Refresh)})
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(state.companies.size) { i ->
                val company = state.companies[i]
                CompanyItem(company = company, modifier = Modifier.fillMaxWidth().clickable{
                   // TODO
                })
                if(i < state.companies.size){
                    Divider(Modifier.padding(horizontal = 16.dp,))
                }

            }
        }


    }
}
