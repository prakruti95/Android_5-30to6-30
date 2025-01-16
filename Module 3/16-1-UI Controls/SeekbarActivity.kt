package com.example.uicontrols2

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.webkit.WebView
import android.widget.ImageView
import android.widget.SeekBar
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SeekbarActivity : AppCompatActivity(), SeekBar.OnSeekBarChangeListener {

    lateinit var seek1:SeekBar
    lateinit var seek2:SeekBar
    lateinit var seek3:SeekBar
    lateinit var img1:ImageView
    lateinit var webView: WebView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_seekbar)

        seek1 = findViewById(R.id.seek1)
        seek2 = findViewById(R.id.seek2)
        seek3 = findViewById(R.id.seek3)
        img1 = findViewById(R.id.img)
        webView = findViewById(R.id.web)
        webView.loadUrl("https://www.tops-int.com")

        seek1.setOnSeekBarChangeListener(this)
        seek2.setOnSeekBarChangeListener(this)
        seek3.setOnSeekBarChangeListener(this)


    }

    override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean)
    {
            var r= seek1.progress
            var g = seek2.progress
            var b = seek3.progress

            img1.setBackgroundColor(Color.rgb(r,g,b))

    }

    override fun onStartTrackingTouch(p0: SeekBar?)
    {

    }

    override fun onStopTrackingTouch(p0: SeekBar?)
    {

    }
}