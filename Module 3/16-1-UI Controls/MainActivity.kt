package com.example.uicontrols2

import android.os.Bundle
import android.widget.Button
import android.widget.ProgressBar
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity()
{
    lateinit var pb:ProgressBar
    lateinit var btn1:Button
    lateinit var btn2:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        pb = findViewById(R.id.pb)
        btn1 = findViewById(R.id.btnp)
        btn2 = findViewById(R.id.btnm)

        btn1.setOnClickListener {

            pb.incrementProgressBy(1)
           setProgress(100*pb.progress)

        }
        btn2.setOnClickListener {

            pb.incrementProgressBy(-1)
            setProgress(100*pb.progress)
        }


    }
}