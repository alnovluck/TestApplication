package com.alnov.testapplication.data.mapper

import com.alnov.testapplication.data.model.WebSocketResponse
import com.alnov.testapplication.domain.model.WebSocketModel

class WebSocketMapper : Mapper<WebSocketResponse, WebSocketModel> {
    override fun mapFromResponse(response: WebSocketResponse): WebSocketModel {
        return WebSocketModel(
            response.type,
            response.symbol,
            response.topTierFullVolume
        )
    }
}