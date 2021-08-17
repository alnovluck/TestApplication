package com.alnov.testapplication.domain.model

data class CryptoRequest(
    var pageNum: Int,
    var limit: Int = 10,
    var tsym: String = "IDR"
)