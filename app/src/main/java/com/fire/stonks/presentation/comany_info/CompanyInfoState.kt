package com.fire.stonks.presentation.comany_info

import com.fire.stonks.domain.model.CompanyInfo

data class CompanyInfoState(
    val stockInfos : List<CompanyInfo> = emptyList(),
    val company : CompanyInfo? = null,
    val isLoading : Boolean = false,
    val error : String? = null
) {
}