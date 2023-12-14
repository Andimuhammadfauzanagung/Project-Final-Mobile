package com.D121211094.Bobburgers

import android.app.Application
import com.D121211094.Bobburgers.data.AppContainer
import com.D121211094.Bobburgers.data.DefaultAppContainer

class MyApplication: Application() {

    lateinit var container: AppContainer

    override fun onCreate() {
        super.onCreate()
        container = DefaultAppContainer()
    }

}