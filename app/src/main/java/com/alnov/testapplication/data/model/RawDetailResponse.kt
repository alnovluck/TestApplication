package com.alnov.testapplication.data.model

import com.google.gson.annotations.SerializedName

data class RawDetailResponse(
    @SerializedName("CHANGEHOUR")
    val changeHour: Double,
    @SerializedName("CHANGEPCTHOUR")
    val changePCTHour: Double,
    @SerializedName("PRICE")
    val price: Double
)