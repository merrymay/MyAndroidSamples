package com.may.myandroidsamples

import android.app.Application
import android.arch.lifecycle.ProcessLifecycleOwner
import android.util.Log
import java.text.SimpleDateFormat
import java.util.*

class MyApplication : Application() {

    private  val appLifecycleListener : SampleLifecycleListener by lazy {
        SampleLifecycleListener()
    }

    override fun onCreate() {
        super.onCreate()


//yyyyMMddHHmmss
        val sdf = SimpleDateFormat("MMddHHmmss")
        val c1 = Calendar.getInstance()
        val notiId : Int =  sdf.format(c1.time).toInt()
        //Int.MAX_VALUE //21 47 48 36 47 mm dd hh mm ss


        Log.d("Time", "notiId = ${notiId}")
        setupLifecycleListener()
    }

    private fun setupLifecycleListener(){
        ProcessLifecycleOwner.get().lifecycle.addObserver(appLifecycleListener)
    }
}