package com.example.jsonex2

import android.os.Bundle
import android.widget.ListView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.VolleyError
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONArray
import org.json.JSONObject

class MainActivity : AppCompatActivity()
{
    lateinit var listView: ListView
    lateinit var list:MutableList<Model>

    override fun onCreate(savedInstanceState: Bundle?)
    {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listView = findViewById(R.id.list)
        list = ArrayList()

        var stringRequest = StringRequest(Request.Method.GET,"https://www.simplifiedcoding.net/demos/view-flipper/heroes.php",object:Response.Listener<String>{
            override fun onResponse(response: String?)
            {
                var jsonobject = JSONObject(response)
                var jsonarray = jsonobject.getJSONArray("heroes")

                //var jsonArray = JSONArray(response)
                for(i in 0 until  jsonarray.length())
                {
                    var jsonobject2 = jsonarray.getJSONObject(i)

                    var name = jsonobject2.getString("name")
                    var image = jsonobject2.getString("imageurl")

                    var m = Model()
                    m.name=name
                    m.url=image

                    list.add(m)
                }

                    var adapter = MyAdapter(applicationContext,list)
                    listView.adapter=adapter

            }
        },object:Response.ErrorListener{
            override fun onErrorResponse(error: VolleyError?)
            {
                Toast.makeText(applicationContext, "No Internet", Toast.LENGTH_SHORT).show()
            }
        })
        var queue: RequestQueue = Volley.newRequestQueue(this)
        queue.add(stringRequest)

    }
}