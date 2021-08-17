package com.alnov.testapplication.presentation.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.alnov.testapplication.domain.common.SimpleError
import com.alnov.testapplication.domain.common.SimpleResult

abstract class BaseViewModel : ViewModel() {

    protected val successSnackbar = MutableLiveData<String>()
    fun successSnackbar() = successSnackbar as LiveData<String>

    protected fun postSuccessSnackbar(message: String) {
        successSnackbar.postValue(message)
    }
}