package com.alnov.testapplication.data.di

import com.alnov.testapplication.data.CryptoRepositoryImpl
import com.alnov.testapplication.data.mapper.CryptoMapper
import com.alnov.testapplication.data.mapper.WebSocketMapper
import com.alnov.testapplication.data.service.CryptoAPI
import com.alnov.testapplication.data.service.WebSocketApi
import com.alnov.testapplication.domain.repository.CryptoRepository
import com.tinder.scarlet.Scarlet
import org.koin.dsl.module
import retrofit2.Retrofit



val dataModule = module {

    single { get<Retrofit>().create(CryptoAPI::class.java) }

    single<CryptoRepository> {
        CryptoRepositoryImpl(get(), get(), get(), get())
    }

    single {
        get<Scarlet>().create(WebSocketApi::class.java)
    }

    single {
        CryptoMapper()
    }

    single {
        WebSocketMapper()
    }
}