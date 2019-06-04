package com.may.myandroidsamples.viewmodel.livedata

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel

class MyViewModel(private var count: Int = 0) : ViewModel() {
    val changeNotifier = MutableLiveData<Int>()
    var strCount = changeNotifier.value.toString()


    fun increment() { changeNotifier.value = ++count }
}