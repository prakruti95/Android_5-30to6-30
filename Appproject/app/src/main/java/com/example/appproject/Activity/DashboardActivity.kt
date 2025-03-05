package com.example.appproject.Activity

import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.content.SharedPreferences
import android.os.Build
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.WindowManager
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.appproject.R
import com.example.appproject.databinding.ActivityDashboardBinding

class DashboardActivity : AppCompatActivity()
{
    private lateinit var binding: ActivityDashboardBinding
    lateinit var sharedPreferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityDashboardBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        sharedPreferences = getSharedPreferences("Appproject", Context.MODE_PRIVATE)
        binding.dashboardtoolbar.setTitle("WELCOME "+sharedPreferences.getString("n1","NameError"))
        setSupportActionBar(binding.dashboardtoolbar)
        if (Build.VERSION.SDK_INT >= 21)
        {
            val window = this.window
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            window.statusBarColor = this.resources.getColor(R.color.white)
        }
    }
    override fun onBackPressed() {
        //super.onBackPressed()

        var alertDialog = AlertDialog.Builder(this)
        alertDialog.setTitle("Are you sure you want to exit?")
        alertDialog.setPositiveButton("YES",{ dialogInterface: DialogInterface, i: Int ->

            finishAffinity()
        })
        alertDialog.setNegativeButton("NO",{ dialogInterface: DialogInterface, i: Int ->
            dialogInterface.cancel()
        })
        alertDialog.show()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean
    {
        menuInflater.inflate(R.menu.dashboard_option_menu,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean
    {
        when(item.itemId)
        {
            R.id.logout->
            {
                sharedPreferences.edit().clear().commit()
                startActivity(Intent(applicationContext,LoginActivity::class.java))
                finish()
            }
        }
        return super.onOptionsItemSelected(item)
    }
}