package com.fire.stonks.domain.model

/**import androidx.compose.runtime.Composable
import com.google.swiperefresh.rememberSwipeRefreshState
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.fire.stonks.presentation.company_listings.CompanyListingsViewModel
import androidx.hilt.navigation.compose.hiltViewModel


@Composable
@Destination(start = true)
 fun CompanyListingsScreen (
    navigator : DestinationsNavigator,
    viewModel: CompanyListingsViewModel = hiltViewModel()
){
     val swipeRefreshState = rememberSwipeRefreshState(
          isRefreshing = viewModel.state.isRefreshing
     )



}
**/