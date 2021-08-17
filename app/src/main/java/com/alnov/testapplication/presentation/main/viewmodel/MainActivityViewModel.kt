package com.alnov.testapplication.presentation.main.viewmodel

import com.alnov.testapplication.presentation.base.BaseViewModel
import com.alnov.testapplication.presentation.utils.UserManager

class MainActivityViewModel(private val userManager: UserManager) : BaseViewModel() {

    fun onUserSignOut() {
        userManager.endUserSession()
        postSuccessSnackbar("Success logout")
    }

}