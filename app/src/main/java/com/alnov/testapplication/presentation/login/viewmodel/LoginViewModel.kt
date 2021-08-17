package com.alnov.testapplication.presentation.login.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.alnov.testapplication.presentation.base.BaseViewModel
import com.alnov.testapplication.presentation.utils.Constants.LoginFlow
import com.alnov.testapplication.presentation.utils.UserManager

class LoginViewModel(private val userManager: UserManager) :
    BaseViewModel() {

    private var _loginFlow = MutableLiveData<LoginFlow>()
    val loginFlow = _loginFlow as LiveData<LoginFlow>

    init {
        onCheckUserAuth()
    }

    private fun onCheckUserAuth() {
        if (userManager.isSessionActive()) {
            navigate(LoginFlow.HomePage)
        } else {
            userManager.endUserSession()
            navigate(LoginFlow.LoginPage)
        }
    }

    fun navigate(flow: LoginFlow) {
        _loginFlow.postValue(flow)
    }

    fun onUserLogin(email: String) {
        userManager.startUserSession()
        userManager.email = email.orEmpty()
        postSuccessSnackbar("Success login")
        navigate(LoginFlow.HomePage)
    }
}