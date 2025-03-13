package com.example.appproject.Admin.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.appproject.Admin.Model.AdminModel
import com.example.appproject.R

class AdminAdapter(var context:Context,var list:MutableList<AdminModel>) :BaseAdapter()
{
    override fun getCount(): Int
    {
        return list.size
    }

    override fun getItem(position: Int): Any
    {
        return list.get(position)
    }

    override fun getItemId(position: Int): Long
    {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View
    {
        var layout = LayoutInflater.from(context)
        var view = layout.inflate(R.layout.design_admin_dashboard,parent,false)

        var image:ImageView = view.findViewById(R.id.img)
        var text:TextView = view.findViewById(R.id.txt)

        image.setImageResource(list.get(position).image)
        text.setText(list.get(position).name)

        return view
    }

}