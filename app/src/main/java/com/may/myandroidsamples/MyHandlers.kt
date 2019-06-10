package com.may.myandroidsamples

import android.util.Log
import android.view.View

class MyHandlers {
    fun onClickFriend(view: View){
        Log.d("MySample", "View is clicked! ${view.id}")
    }

}