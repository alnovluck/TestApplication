package com.alnov.testapplication.presentation.datafeed.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.alnov.testapplication.domain.model.WebSocketModel
import com.alnov.testapplication.domain.usecase.GetWebSocketUseCase
import com.alnov.testapplication.presentation.base.BaseViewModel
import kotlinx.coroutines.flow.collect

class DataFeedViewModel(private val getWebSocketUseCase: GetWebSocketUseCase) : BaseViewModel() {

    val webSocketData: LiveData<WebSocketModel> = liveData {
        getWebSocketUseCase.execute().collect { data ->
            emit(data)
        }
    }
}