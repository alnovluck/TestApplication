package com.alnov.testapplication.data.model

import com.google.gson.annotations.SerializedName

data class WebSocketResponse(
    @SerializedName("TYPE")
    val type: Int,
    @SerializedName("SYMBOL")
    val symbol: String,
    @SerializedName("TOPTIERFULLVOLUME")
    val topTierFullVolume: Double
)