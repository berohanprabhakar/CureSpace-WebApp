package com.example.webview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.webkit.WebSettings
import android.webkit.WebView   
import android.webkit.WebViewClient
import com.example.webview.databinding.ActivityMainBinding
import javax.net.ssl.SSLSessionBindingEvent

class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding
    private val link = "https://coronabeds.jantasamvad.org"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

       /* binding.WebView.apply {
            loadUrl(link)

        }*/

       // myHtml()

        turnwebtoapp()
    }

    private fun turnwebtoapp(){

        binding.WebView.apply {
          webViewClient = WebViewClient()
            loadUrl(link)

            settings.apply {
                javaScriptEnabled= true
                setAppCacheEnabled(true)
                cacheMode= WebSettings.LOAD_DEFAULT
                setSupportZoom(false)
                builtInZoomControls = false
                displayZoomControls = false
                textZoom = 100
                blockNetworkImage = false
                loadsImagesAutomatically = true
            }
        }.canGoBack()
    }

    override fun onBackPressed() {
        if(binding.WebView.canGoBack()){
            binding.WebView.goBack()
        }else {
            super.onBackPressed()
        }
    }
    private fun myHtml(){

        val customHtml = "<html><body>" +
                "<h1>Hello There</h1>"+
                "<h2>Heading 2</h2>" +
                "<h3>Heading 3</h3>" +
                "<p>This is a sample Paragraph</p>"+
        "</html></body>"


        binding.WebView.apply {
            loadData(customHtml,
            "text/html",
            "UTF-8")

        }
    }
}
