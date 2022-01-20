package com.example.kotlinwebbrowser

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.inputmethod.EditorInfo
import android.webkit.WebSettings
import android.webkit.WebView
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var et_adress: EditText
    private lateinit var wv_view: WebView
    private val myWebClient: MyWebClient = MyWebClient()
    private var address = "https://www.google.com"

    private val GOOGLE_URL = "https://www.google.com"
    private val NAVER_URL = "https://www.naver.com"
    private val DAUM_URL = "https://www.daum.net"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        onBind()
        setWebView()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main, menu)

        return true
    }

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)
        menuInflater.inflate(R.menu.context, menu)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_share -> {
                var intent = Intent(Intent.ACTION_SEND)
                intent.setType("text/plain")

                val msg = (wv_view.url).toString()
                intent.putExtra(Intent.EXTRA_TEXT, msg)
                val shareIntent = Intent.createChooser(intent, "share")
                startActivity(shareIntent)

            }

            R.id.action_browser -> {
                startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(wv_view.url)))

            }
        }
        return super.onContextItemSelected(item)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_google, R.id.action_home -> {
                wv_view.loadUrl(GOOGLE_URL)
                et_adress.setText(GOOGLE_URL)
                return true
            }
            R.id.action_naver -> {
                wv_view.loadUrl(NAVER_URL)
                et_adress.setText(NAVER_URL)
                return true
            }
            R.id.action_daum -> {
                wv_view.loadUrl(DAUM_URL)
                et_adress.setText(DAUM_URL)
                return true
            }
            R.id.action_call -> {
                val intent = Intent(Intent.ACTION_DIAL)
                //전화
                //암시적 인텐트
                intent.data = Uri.parse("tel:031-123-4567")
                if (intent.resolveActivity(packageManager) != null) {
                    startActivity(intent)
                }
                return true
            }


        }
        return super.onOptionsItemSelected(item)
    }


    private fun onBind() {
        et_adress = findViewById(R.id.et_address)
        et_adress.setText(address)

        //listener( 뷰, 액션id, 이벤트)

        et_adress.setOnEditorActionListener { _, actiondId, _ ->
            if (actiondId == EditorInfo.IME_ACTION_SEARCH) {
                var etUrl = et_adress.text.toString()
                if (etUrl !in "https://") {
                    etUrl = "https://$etUrl"
                }
                wv_view.loadUrl(etUrl)
                et_adress.setText(etUrl)
                true
            } else {
                false
            }

        }
        wv_view = findViewById(R.id.wv_view)
    }

    private fun setWebView() {
        //웹뷰 기본 설정
        wv_view.settings.javaScriptEnabled = true
        wv_view.settings.domStorageEnabled = true
        wv_view.settings.javaScriptCanOpenWindowsAutomatically = true
        wv_view.settings.cacheMode = WebSettings.LOAD_NO_CACHE
        wv_view.settings.loadsImagesAutomatically = true
        wv_view.settings.builtInZoomControls = true
        wv_view.settings.setSupportZoom(true)
        wv_view.settings.setSupportMultipleWindows(true)
        wv_view.settings.loadWithOverviewMode = true
        wv_view.settings.useWideViewPort = true

        wv_view.webViewClient = myWebClient

        registerForContextMenu(wv_view)
        wv_view.loadUrl(address)

    }

    override fun onBackPressed() {
        if (wv_view.canGoBack()) {
            wv_view.goBack()
        } else {
            super.onBackPressed()
        }
    }

}