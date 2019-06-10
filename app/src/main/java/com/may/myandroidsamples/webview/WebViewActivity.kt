package com.may.myandroidsamples.webview

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import android.support.v4.content.ContextCompat.startActivity
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.webkit.WebView
import android.webkit.WebViewClient
import com.may.myandroidsamples.R
import kotlinx.android.synthetic.main.activity_webview.*
import kotlinx.android.synthetic.main.activity_webview.view.*

class WebViewActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        super.setContentView(R.layout.activity_webview)


        // JS 테스트할때 -
        // webview.loadUrl("https://merrymay.github.io/may.github.io/index.html")

        // MyWebViewClient 테스트할때
        webview.loadUrl("https://www.google.com")

        // enable js
        webview.settings.javaScriptEnabled = true
        webview.addJavascriptInterface(WebAppInterface(this), "Android")

        // define web client
        webview.webViewClient = MyWebViewClient(this)
    }


    private class MyWebViewClient internal constructor(private val activity: Activity) : WebViewClient() {

        override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
            if (Uri.parse(url).host == "www.google.com") {
                // This is my web site, so do not override; let my WebView load the page
                return false
            }

            Log.d("MySample", "URL is not a google's address. Starting to open a browser")
            // Otherwise, the link is not for a page on my site, so launch another Activity that handles URLs
            Intent(Intent.ACTION_VIEW, Uri.parse(url)).apply {
                activity.startActivity(this)
            }

            return true
        }
    }


}


