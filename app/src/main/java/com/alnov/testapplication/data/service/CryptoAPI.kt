package com.alnov.testapplication.data.service

import com.alnov.testapplication.data.common.Constants.QUERY_PARAM_LIMIT
import com.alnov.testapplication.data.common.Constants.QUERY_PARAM_PAGE
import com.alnov.testapplication.data.common.Constants.QUERY_PARAM_TSYM
import com.alnov.testapplication.data.common.SimpleResponse
import com.alnov.testapplication.data.model.CryptoResponse
import retrofit2.http.GET
import retrofit2.http.Query


interface CryptoAPI {

    @GET("data/top/totaltoptiervolfull")
    suspend fun getCryptoData(
        @Query(QUERY_PARAM_LIMIT) limit: Int,
        @Query(QUERY_PARAM_PAGE) pageNum: Int,
        @Query(QUERY_PARAM_TSYM) tsym: String
    ): SimpleResponse<List<CryptoResponse>>


}