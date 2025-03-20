package com.example.appproject.Admin.Activity

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.appproject.Admin.Adapter.AdminAdapter
import com.example.appproject.Admin.Model.AdminModel
import com.example.appproject.R
import com.example.appproject.databinding.ActivityAdminMainBinding
import com.example.appproject.databinding.ActivityCartBinding

class AdminMainActivity : AppCompatActivity()
{
    private lateinit var binding: ActivityAdminMainBinding
    lateinit var admindashboardlist:MutableList<AdminModel>

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityAdminMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        admindashboardlist = ArrayList()

        admindashboardlist.add(AdminModel(R.drawable.baseline_add_box_24,"Add Category"))
        admindashboardlist.add(AdminModel(R.drawable.baseline_preview_24,"Add Product"))
        admindashboardlist.add(AdminModel(R.drawable.baseline_preview_24,"View Orders"))



        var adapter = AdminAdapter(applicationContext,admindashboardlist)
        binding.grid.adapter=adapter
    }
}