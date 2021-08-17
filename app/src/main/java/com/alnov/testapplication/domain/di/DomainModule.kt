package com.alnov.testapplication.domain.di

import com.alnov.testapplication.domain.usecase.GetCryptoUseCase
import com.alnov.testapplication.domain.usecase.GetWebSocketUseCase
import org.koin.dsl.module



val domainModule = module {
    single {
        GetCryptoUseCase(get())
    }

    single {
        GetWebSocketUseCase(get())
    }
}