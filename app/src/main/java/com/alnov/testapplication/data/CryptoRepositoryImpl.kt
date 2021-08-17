package com.alnov.testapplication.data

import com.alnov.testapplication.data.common.Constants.WEB_SOCKET_SUBSCRIBE_MODEL
import com.alnov.testapplication.data.common.mapToResult
import com.alnov.testapplication.data.mapper.CryptoMapper
import com.alnov.testapplication.data.mapper.WebSocketMapper
import com.alnov.testapplication.data.service.CryptoAPI
import com.alnov.testapplication.data.service.WebSocketApi
import com.alnov.testapplication.domain.common.Result
import com.alnov.testapplication.domain.common.SimpleError
import com.alnov.testapplication.domain.common.SimpleResult
import com.alnov.testapplication.domain.model.CryptoModel
import com.alnov.testapplication.domain.model.CryptoRequest
import com.alnov.testapplication.domain.repository.CryptoRepository
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow

class CryptoRepositoryImpl(
    private val api: CryptoAPI,
    private val cryptoMapper: CryptoMapper,
    private val webSocketMapper: WebSocketMapper,
    private val webSocket: WebSocketApi
) :
    CryptoRepository {

    override suspend fun getCryptoData(param: CryptoRequest): SimpleResult<List<CryptoModel>> {
        return try {
            api.getCryptoData(param.limit, param.pageNum, param.tsym).mapToResult(cryptoMapper)
        } catch (e: Exception) {
            Result.Failure(SimpleError(e.localizedMessage))
        }
    }

    override suspend fun getWebSocketData() = flow {
        webSocket.subscribe(WEB_SOCKET_SUBSCRIBE_MODEL)
        webSocket.observeResponse().collect { response ->
            emit(webSocketMapper.mapFromResponse(response))
        }
    }
}