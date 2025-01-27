package com.example.roomdbex

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.room.Room

class AdduserAcitivity : AppCompatActivity()
{
    lateinit var edt1:EditText
    lateinit var edt2:EditText
    lateinit var btn1:Button
    lateinit var db:MyDbClass
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_adduser_acitivity)

        edt1 = findViewById(R.id.edt1)
        edt2 = findViewById(R.id.edt2)
        btn1 = findViewById(R.id.btn1)
        db = Room.databaseBuilder(applicationContext, MyDbClass::class.java, "myDatabase")
            .allowMainThreadQueries()
            .build()
        btn1.setOnClickListener {

            var name = edt1.text.toString()
            var email = edt2.text.toString()

            var user = User()
            user.name=name
            user.email=email

            db.daoClass().insertdata(user)
            Toast.makeText(applicationContext, "Inserted", Toast.LENGTH_SHORT).show()

        }

    }
}