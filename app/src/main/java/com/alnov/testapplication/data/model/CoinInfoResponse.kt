package com.alnov.testapplication.data.model

import com.google.gson.annotations.SerializedName

data class CoinInfoResponse(
    @SerializedName("FullName")
    val fullName: String,
    @SerializedName("Id")
    val id: String,
    @SerializedName("Name")
    val name: String
)