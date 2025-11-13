package com.fire.stonks.domain.model

import com.squareup.moshi.Json

data class companyInfo(
   val name:String,
   val description:String,
    val symbol:String,
    val country :String,
   val industry:String,

    )