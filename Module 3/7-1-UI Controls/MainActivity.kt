package com.example.uicontrolsex

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.GridView
import android.widget.ListView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.daimajia.slider.library.SliderLayout
import com.daimajia.slider.library.SliderTypes.TextSliderView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity()
{
    lateinit var listView: GridView
    lateinit var list:MutableList<Model>
    lateinit var f1:FloatingActionButton
    lateinit var sliderLayout: SliderLayout
    var map = HashMap<String,Int>()

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listView = findViewById(R.id.list)
        list = ArrayList()
        sliderLayout = findViewById(R.id.slider)
        f1 = findViewById(R.id.f1)

        map.put("Product1",R.drawable.hoddiee)
        map.put("Product2",R.drawable.notebook)
        map.put("Product3",R.drawable.water_heater)


        for(i in map.keys)
        {
            var txtslider = TextSliderView(this)

            txtslider.image(map.get(i)!!)

            sliderLayout.addSlider(txtslider)

        }

        sliderLayout.setPresetTransformer(SliderLayout.Transformer.ZoomOut)

        f1.setOnClickListener {

            Snackbar.make(it,"Hello",Snackbar.LENGTH_LONG).show()
            //Toast.makeText(applicationContext, "OK", Toast.LENGTH_SHORT).show()

        }

        list.add(Model(R.drawable.a,"Laptop1","1000"))
        list.add(Model(R.drawable.b,"Laptop2","2000"))
        list.add(Model(R.drawable.c,"Laptop3","3000"))
        list.add(Model(R.drawable.a,"Laptop1","1000"))
        list.add(Model(R.drawable.b,"Laptop2","2000"))
        list.add(Model(R.drawable.c,"Laptop3","3000"))
        list.add(Model(R.drawable.a,"Laptop1","1000"))
        list.add(Model(R.drawable.b,"Laptop2","2000"))
        list.add(Model(R.drawable.c,"Laptop3","3000"))
        list.add(Model(R.drawable.a,"Laptop1","1000"))
        list.add(Model(R.drawable.b,"Laptop2","2000"))
        list.add(Model(R.drawable.c,"Laptop3","3000"))


        var adapter = MyAdapter(applicationContext,list)
        listView.adapter=adapter

    }
}