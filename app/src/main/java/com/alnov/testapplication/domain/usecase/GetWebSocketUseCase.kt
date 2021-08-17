package com.alnov.testapplication.domain.usecase

import com.alnov.testapplication.domain.repository.CryptoRepository

class GetWebSocketUseCase(private val repository: CryptoRepository) {
    suspend fun execute() = repository.getWebSocketData()
}