package com.alnov.testapplication.domain.repository

import com.alnov.testapplication.domain.common.SimpleResult
import com.alnov.testapplication.domain.model.CryptoModel
import com.alnov.testapplication.domain.model.CryptoRequest
import com.alnov.testapplication.domain.model.WebSocketModel
import kotlinx.coroutines.flow.Flow


interface CryptoRepository {
    suspend fun getCryptoData(param: CryptoRequest): SimpleResult<List<CryptoModel>>
    suspend fun getWebSocketData(): Flow<WebSocketModel>
}