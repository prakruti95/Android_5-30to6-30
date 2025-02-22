package com.example.multimediaex


import android.media.MediaPlayer
import android.os.Bundle
import android.view.SurfaceHolder
import android.view.SurfaceView
import androidx.appcompat.app.AppCompatActivity
import java.io.IOException


class MainActivity2 : AppCompatActivity(),SurfaceHolder.Callback
{
    var url: String = "https://prakrutitech.buzz/AndroidAPI/movie.mp4"
    lateinit var mediaPlayer: MediaPlayer
    lateinit var surfaceView: SurfaceView
    lateinit var holder: SurfaceHolder
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        surfaceView = findViewById<SurfaceView>(R.id.surfaceView)
        mediaPlayer = MediaPlayer()
        holder = surfaceView.holder
        holder.setFixedSize(800, 480)
        holder.addCallback(this)
        holder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS)

    }


    private fun play() {
        try {
            mediaPlayer!!.setDataSource(url)
            mediaPlayer!!.prepare()
        } catch (e: IllegalArgumentException) {
            e.printStackTrace()
        } catch (e: IllegalStateException) {
            e.printStackTrace()
        } catch (e: IOException) {
            e.printStackTrace()
        }
        mediaPlayer!!.start()
    }

    override fun surfaceCreated(holder: SurfaceHolder) {
        mediaPlayer!!.setDisplay(holder)
        play()
    }

    override fun surfaceChanged(holder: SurfaceHolder, format: Int, width: Int, height: Int) {

    }

    override fun surfaceDestroyed(holder: SurfaceHolder) {
    }


}