package com.may.myandroidsamples

import android.app.Application
import android.arch.lifecycle.ProcessLifecycleOwner

class MyApplication : Application() {

    private  val appLifecycleListener : SampleLifecycleListener by lazy {
        SampleLifecycleListener()
    }

    override fun onCreate() {
        super.onCreate()
        setupLifecycleListener()
    }

    private fun setupLifecycleListener(){
        ProcessLifecycleOwner.get().lifecycle.addObserver(appLifecycleListener)
    }
}