package com.alnov.testapplication.presentation.di

import android.content.SharedPreferences
import com.alnov.testapplication.presentation.main.viewmodel.MainActivityViewModel
import com.alnov.testapplication.presentation.datafeed.viewmodel.DataFeedViewModel
import com.alnov.testapplication.presentation.login.viewmodel.LoginViewModel
import com.alnov.testapplication.presentation.utils.Constants.SHARED_PREFERENCE_NAME
import com.alnov.testapplication.presentation.utils.SharedPreferenceHelper
import com.alnov.testapplication.presentation.utils.UserManager
import com.alnov.testapplication.presentation.wathclist.viewmodel.WatchListViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module



val presentationModule = module {

    viewModel {
        LoginViewModel(get())
    }

    viewModel {
        WatchListViewModel(get())
    }

    viewModel {
        MainActivityViewModel(
            get()
        )
    }

    viewModel {
        DataFeedViewModel(
            get()
        )
    }

    single<SharedPreferences> {
        androidApplication().getSharedPreferences(SHARED_PREFERENCE_NAME, 0)
    }

    single {
        SharedPreferenceHelper(get())
    }

    single {
        UserManager(get())
    }
}