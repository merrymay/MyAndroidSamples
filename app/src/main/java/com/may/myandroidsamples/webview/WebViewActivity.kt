package com.may.myandroidsamples.webview

import android.annotation.TargetApi
import android.app.Activity
import android.app.Dialog
import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.os.Message
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.KeyEvent
import android.view.View
import android.view.ViewGroup
import android.webkit.WebChromeClient
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.LinearLayout
import com.may.myandroidsamples.R
import kotlinx.android.synthetic.main.activity_webview.*







class WebViewActivity : AppCompatActivity(){

    companion object {
        var hasNewWindow = false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        super.setContentView(R.layout.activity_webview)

        WebView.setWebContentsDebuggingEnabled(true);

        // JS 테스트할때 -
        webview.loadUrl("https://merrymay.github.io/may.github.io/index.html")

        // MyWebViewClient 테스트할때
        //webview.loadUrl("https://www.google.com")

        // enable js
        webview.settings.javaScriptEnabled = true
        webview.addJavascriptInterface(WebAppInterface(this), "Android")

        // enable multiple window popup
        // - https://ymson.tistory.com/m/274
        webview.settings.setSupportMultipleWindows(true)
        webview.settings.javaScriptCanOpenWindowsAutomatically = true
        webview.webChromeClient = MyWebChromeClient(this, webview)


        // define web client
        webview.webViewClient = MyWebViewClient(this)
        webview.clearCache(true)
    }


    // Navigating web page history
    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {

        if( keyCode == KeyEvent.KEYCODE_BACK && hasNewWindow) {
            Log.d("MySample","WebViewActivity.onKeyDown >> webview's sub window remove!")
            hasNewWindow = false
            webview.removeAllViews()
            return true
        }
        // Check if the key event was the Back button and if there's history
        if (keyCode == KeyEvent.KEYCODE_BACK && webview.canGoBack()) {
            Log.d("MySample","WebViewActivity.onKeyDown >> webview goback!")
            webview.goBack()
            return true
        }
        // If it wasn't the Back key or there's no web page history, bubble up to the default
        // system behavior (probably exit the activity)
        Log.d("MySample","WebViewActivity.onKeyDown >> super.onKeyDown!")
        return super.onKeyDown(keyCode, event)
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


    private class MyWebChromeClient internal constructor(private val activity: Activity, private val parentWebView: WebView) : WebChromeClient() {
        override fun onCreateWindow(view: WebView?, isDialog: Boolean, isUserGesture: Boolean, resultMsg: Message?): Boolean {

            Log.d("MySample", "MyWebChromeClient.onCreateWindow called!")
            val newWebView = WebView(activity)
            newWebView.settings.javaScriptEnabled = true


            newWebView.webViewClient = object : WebViewClient(){
                override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean {
                    return false
                }
            }


            /*
            // Case 1 - Dialog 에 띄우는 방식
            var dialog = Dialog(activity)
            dialog.setContentView(newWebView)
            dialog.show()


            newWebView.webChromeClient = object : WebChromeClient() {
                override fun onCloseWindow(window: WebView) {
                    Log.d("MySample", "MyWebChromeClient.newWebView.onCloseWindow called!")
                    dialog.dismiss()
                }
            }
            */



            // Case 2 - View 추가하는 방식
            newWebView?.layoutParams = LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
            parentWebView.addView(newWebView)
            hasNewWindow = true

            newWebView.webChromeClient = object: WebChromeClient() {

                override fun onCloseWindow(window: WebView?) {
                    Log.d("MySample", "MyWebChromeClient.onCloseWindow called!")
                    parentWebView.removeView(window)
                    hasNewWindow = false
                }
            }


            val transport = resultMsg?.obj as WebView.WebViewTransport
            transport.webView = newWebView
            resultMsg?.sendToTarget()

            return true

        }


        override fun onCloseWindow(window: WebView?) {
            Log.d("MySample", "MyWebChromeClient.onCloseWindow called for ParentWebView!")
            super.onCloseWindow(window)
            parentWebView.removeView(window)
        }
    }

}


