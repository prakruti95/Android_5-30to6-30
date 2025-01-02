package com.example.menuex

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.PopupMenu
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.menuex.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity()
{

    lateinit var binding:ActivityMainBinding

    lateinit var toolbar: Toolbar
//    lateinit var btn:Button
//   lateinit var btn2:Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)



        toolbar = findViewById(R.id.tool)
       setSupportActionBar(toolbar)

//        btn = findViewById(R.id.btn1)
//       btn2 = findViewById(R.id.btn2)




        registerForContextMenu(binding.btn1)

        binding.btn2.setOnClickListener {

            var popupmenu = PopupMenu(applicationContext,binding.btn2)
            popupmenu.menuInflater.inflate(R.menu.popup,popupmenu.menu)
            popupmenu.show()


        }



    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean
    {
        menuInflater.inflate(R.menu.option,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean
    {
        when(item.itemId)
        {
            R.id.i1->
            {
                Toast.makeText(applicationContext, "clicked", Toast.LENGTH_SHORT).show()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?)
    {
        menuInflater.inflate(R.menu.context,menu)
        super.onCreateContextMenu(menu, v, menuInfo)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean
    {
        when(item.itemId)
        {
            R.id.i2->
            {
                Toast.makeText(applicationContext, "SMS SENT", Toast.LENGTH_SHORT).show()
            }
        }
        return super.onContextItemSelected(item)
    }
}