package com.alnov.testapplication

import com.alnov.testapplication.BuildConfig.*
import com.alnov.testapplication.data.service.RetrofitFactory
import com.alnov.testapplication.data.service.ScarletFactory
import org.koin.dsl.module



val remoteModule = module {
    single {
        RetrofitFactory.create(BASE_URL, API_KEY)
    }
    single {
        ScarletFactory.create(BASE_URL_WEBSOCKET, API_KEY)
    }
}