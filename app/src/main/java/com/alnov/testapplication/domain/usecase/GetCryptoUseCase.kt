package com.alnov.testapplication.domain.usecase

import com.alnov.testapplication.domain.common.ParamUseCase
import com.alnov.testapplication.domain.model.CryptoModel
import com.alnov.testapplication.domain.model.CryptoRequest
import com.alnov.testapplication.domain.repository.CryptoRepository


class GetCryptoUseCase(private val repository: CryptoRepository) :
    ParamUseCase<CryptoRequest, List<CryptoModel>>() {
    override suspend fun execute(param: CryptoRequest) = repository.getCryptoData(param)
}