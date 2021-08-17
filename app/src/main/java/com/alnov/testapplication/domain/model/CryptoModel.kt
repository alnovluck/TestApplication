package com.alnov.testapplication.domain.model


data class CryptoModel(
    var id:String,
    var name: String,
    var fullName: String,
    var currentPrice: Double,
    var changePrice: Double,
    var changePricePercent: Double
)