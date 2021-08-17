package com.alnov.testapplication.presentation.wathclist.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.alnov.testapplication.domain.common.Result
import com.alnov.testapplication.domain.common.SimpleResult
import com.alnov.testapplication.domain.model.CryptoModel
import com.alnov.testapplication.domain.model.CryptoRequest
import com.alnov.testapplication.domain.usecase.GetCryptoUseCase
import com.alnov.testapplication.presentation.base.BaseViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class WatchListViewModel(
    private val getCryptoUseCase: GetCryptoUseCase
) : BaseViewModel() {

    private var isLoading = false
    private var currentPage = 1
    var cryptoList: MutableList<CryptoModel> = mutableListOf()
        private set

    private var _cryptoData = MutableLiveData<SimpleResult<List<CryptoModel>>>(Result.State.Loading)
    val cryptoData = _cryptoData as LiveData<SimpleResult<List<CryptoModel>>>

    fun refreshData() {
        onRefreshSetting()
        getData()
    }

    fun getData() {
        viewModelScope.launch {
            val request = CryptoRequest(currentPage)
            val result = getCryptoUseCase.execute(request)
            delay(1200)
            _cryptoData.postValue(result)
            isLoading = false
        }
    }

    private fun onRefreshSetting() {
        currentPage = 1
        cryptoList = mutableListOf()
    }

    fun fetchNextPage() {
        if (!isLoading) {
            isLoading = true
            getData()
        }
    }

    fun onUpdatePageNumber() {
        currentPage++
    }
}