package com.may.myandroidsamples.webview

import android.content.Context
import android.util.Log
import android.webkit.JavascriptInterface
import android.widget.Toast

/*
    https://developer.android.com/guide/webapps/webview

    Caution:
    If you've set your targetSdkVersion to 17 or higher,
    you must add the @JavascriptInterface annotation to any method
    that you want available to your JavaScript (the method must also be public).
    If you do not provide the annotation,
    the method is not accessible by your web page when running on Android 4.2 or higher.

 */

// WebView 와 Javascript Interface 를 위해 필요

/** Instantiate the interface and set the context  */
class WebAppInterface(private val mContext: Context) {

    /** Show a toast from the web page  */
    @JavascriptInterface
    fun showToast(toast: String) {
        Log.d("MySample", "showToast method called in WebAppInterface!")
        Toast.makeText(mContext, toast, Toast.LENGTH_SHORT).show()
    }
}