package com.vuabocphet.jav123vn

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import bg.devlabs.fullscreenvideoview.playbackspeed.PlaybackSpeedOptions
import kotlinx.android.synthetic.main.activity_play_video.*
import com.khizar1556.mkvideoplayer.MKPlayerActivity.play
import android.app.Activity
import android.webkit.WebViewClient
import android.widget.VideoView
import com.khizar1556.mkvideoplayer.MKPlayer







class PlayVideo : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_play_video)
        val videoUrl =intent.getStringExtra("path")
        webView.setWebViewClient(WebViewClient())
        webView.getSettings().setJavaScriptEnabled(true)
        webView.setVerticalScrollBarEnabled(false)
        webView.setHorizontalScrollBarEnabled(false)
        webView.getSettings().setLoadWithOverviewMode(true)
        webView.getSettings().setUseWideViewPort(true)
        webView.getSettings().setBuiltInZoomControls(true)
        webView.getSettings().setDisplayZoomControls(false)
        webView.getSettings().setDomStorageEnabled(true)
        webView.loadUrl(videoUrl);
    }
}
