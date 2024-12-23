package com.example.listex1

import android.annotation.SuppressLint
import android.media.MediaPlayer
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.util.Locale

class MainActivity2 : AppCompatActivity(), TextToSpeech.OnInitListener {
    lateinit var txt1:TextView
    lateinit var tts:TextToSpeech
    lateinit var btn1:Button
    lateinit var mediaPlayer: MediaPlayer

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        txt1 = findViewById(R.id.txt1)
        tts = TextToSpeech(applicationContext,this)
        btn1 = findViewById(R.id.btn1)
        mediaPlayer = MediaPlayer.create(applicationContext,R.raw.a)

        btn1.setOnClickListener {

            mediaPlayer.start()

        }

        txt1.setOnClickListener {

            tts.speak(txt1.text.toString(),TextToSpeech.QUEUE_ADD,null)

        }
    }

    override fun onInit(status: Int)
    {
        tts.setSpeechRate(1.00F)
        tts.setPitch(0.8F)
        tts.setLanguage(Locale.US)
    }
}