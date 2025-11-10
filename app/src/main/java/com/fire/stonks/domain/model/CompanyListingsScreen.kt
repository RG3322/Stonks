package com.fire.stonks.domain.model

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.fire.stonks.presentation.company_listings.CompanyListingsEvent


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
//        // Your LazyColumn etc.
//    }
//}
