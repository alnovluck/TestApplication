package com.alnov.testapplication

import android.app.Application
import com.alnov.testapplication.data.di.dataModule
import com.alnov.testapplication.domain.di.domainModule
import com.alnov.testapplication.domain.di.presentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import timber.log.Timber


class AppController: Application() {

    override fun onCreate() {
        super.onCreate()
        instance = this
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
        startKoin{
            androidLogger(Level.NONE)
            androidContext(this@AppController)
            modules(
                dataModule,
                remoteModule,
                domainModule,
                presentationModule
            )
        }
    }

    companion object {
        lateinit var instance: AppController
    }

}