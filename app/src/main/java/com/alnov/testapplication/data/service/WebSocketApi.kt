package com.alnov.testapplication.data.service

import com.alnov.testapplication.data.model.Subscription
import com.alnov.testapplication.data.model.WebSocketResponse
import com.tinder.scarlet.websocket.WebSocketEvent
import com.tinder.scarlet.ws.Receive
import com.tinder.scarlet.ws.Send
import kotlinx.coroutines.flow.Flow

interface WebSocketApi {

    @Send
    fun subscribe(request: Subscription): Boolean

    @Receive
    fun observeResponse(): Flow<WebSocketResponse>

    @Receive
    fun observeConnection(): Flow<WebSocketEvent>
}