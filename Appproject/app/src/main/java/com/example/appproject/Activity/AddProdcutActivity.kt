package com.example.appproject

import android.media.Image
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.activity.result.contract.ActivityResultContracts
import com.example.appproject.ApiConfig.Apiinterface
import com.example.appproject.databinding.ActivityAddProdcutBinding
import com.example.appproject.databinding.ActivityCartBinding
import com.example.appproject.databinding.ActivityWishlistBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.asRequestBody
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File
import java.io.FileOutputStream

class AddProdcutActivity : AppCompatActivity()
{
    lateinit var image: ImageView
    lateinit var btnsubmit:Button
    lateinit var imageuri:Uri
    lateinit var edt1:EditText
    private lateinit var binding: ActivityAddProdcutBinding

    private val contract = registerForActivityResult(ActivityResultContracts.GetContent())
    {
        imageuri = it!!
        image.setImageURI(it)
    }
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityAddProdcutBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        setup()


    }

    private fun setup()
    {
        edt1 = findViewById(R.id.name)

        image = findViewById(R.id.img)
        image.setOnClickListener { contract.launch("image/*") }
        btnsubmit = findViewById(R.id.btn_regi)
        btnsubmit.setOnClickListener { upload() }
    }

    private fun upload()
    {
        val filesDir = applicationContext.filesDir
        val file = File(filesDir,"image.png")
        val inputstream = contentResolver.openInputStream(imageuri)
        val outputstream = FileOutputStream(file)
        inputstream!!.copyTo(outputstream)

        val requestBody = file.asRequestBody("image/*".toMediaTypeOrNull())
        val part = MultipartBody.Part.createFormData("url",file.name,requestBody)
        val name1:RequestBody = RequestBody.Companion.create(MultipartBody.FORM,edt1.text.toString())


        val retrofit = Retrofit.Builder().baseUrl("https://prakrutitech.buzz/AndroidAPI/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(Apiinterface::class.java)


        CoroutineScope(Dispatchers.IO).launch {

            val response = retrofit.uploadImage(part,name1)
            Log.d("Cheezycoder",response.toString())

        }





    }
}