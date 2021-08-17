package com.alnov.testapplication.domain.model

data class WebSocketModel(
    var type: Int? = 0,
    var symbol: String? = "",
    var topTierFullVolume: Double? = 0.0
)