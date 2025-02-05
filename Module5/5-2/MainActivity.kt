package com.example.jsoncrudvolley

import android.content.Intent
import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView.AdapterContextMenuInfo
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.VolleyError
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.jsoncrudvolley.databinding.ActivityMainBinding
import org.json.JSONArray

class MainActivity : AppCompatActivity()
{
    private lateinit var binding: ActivityMainBinding
    lateinit var list: MutableList<Model>

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        list = ArrayList()
        registerForContextMenu(binding.recycler)

        var stringRequest = StringRequest(Request.Method.GET,"https://prakrutitech.buzz/CRUD/view.php",object:Response.Listener<String>{
            override fun onResponse(response: String?)
            {
                var jsonArray = JSONArray(response)
                for(i in 0 until jsonArray.length())
                {
                    var jsonObject = jsonArray.getJSONObject(i)

                    var name = jsonObject.getString("name")
                    var surname = jsonObject.getString("surname")
                    var email = jsonObject.getString("email")
                    var pass = jsonObject.getString("password")

                    var m = Model()
                    m.name=name
                    m.surname=surname
                    m.email=email
                    m.pass=pass

                    list.add(m)
                }

                var adapter = MyAdapter(applicationContext,list)
                binding.recycler.adapter=adapter

            }
        },object:Response.ErrorListener{
            override fun onErrorResponse(error: VolleyError?)
            {
                Toast.makeText(applicationContext, "No Internet", Toast.LENGTH_SHORT).show()

            }



        })
        var queue: RequestQueue = Volley.newRequestQueue(this)
        queue.add(stringRequest)


        binding.f1.setOnClickListener {

            startActivity(Intent(applicationContext,AddActivity::class.java))

        }

    }

    override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?)
    {
        menuInflater.inflate(R.menu.ud_menu,menu)
        super.onCreateContextMenu(menu, v, menuInfo)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean
    {
        when(item.itemId)
        {
            R.id.update->
            {
                Toast.makeText(applicationContext,"UPDATE",Toast.LENGTH_SHORT).show()
            }
        }

        when(item.itemId)
        {
            R.id.delete->
            {
                Toast.makeText(applicationContext,"DELETE",Toast.LENGTH_SHORT).show()
            }
        }
        return super.onContextItemSelected(item)
    }
}