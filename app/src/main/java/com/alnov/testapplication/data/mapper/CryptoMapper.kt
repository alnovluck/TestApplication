package com.alnov.testapplication.data.mapper

import com.alnov.testapplication.data.model.CryptoResponse
import com.alnov.testapplication.domain.model.CryptoModel

class CryptoMapper : Mapper<List<CryptoResponse>, List<CryptoModel>> {
    override fun mapFromResponse(response: List<CryptoResponse>?): List<CryptoModel> {
        return response?.map {
            CryptoModel(
                it.coinInfo.id,
                it.coinInfo.name,
                it.coinInfo.fullName,
                it.raw.rawDetail.price,
                it.raw.rawDetail.changeHour,
                it.raw.rawDetail.changePCTHour
            )
        } ?: listOf()
    }
}
