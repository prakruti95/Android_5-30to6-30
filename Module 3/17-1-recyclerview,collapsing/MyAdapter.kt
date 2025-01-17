package com.example.demo

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(var context:Context,var list: MutableList<Model>) : RecyclerView.Adapter<Myview>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Myview
    {
       var layout = LayoutInflater.from(context)
       var view = layout.inflate(R.layout.design,parent,false)
        return Myview(view)

    }

    override fun getItemCount(): Int
    {
        return list.size
    }

    override fun onBindViewHolder(holder: Myview, position: Int)
    {
        holder.txt1.setText(list.get(position).txt1)
        holder.txt2.setText(list.get(position).txt2)
    }

}
class Myview(itemview:View) : RecyclerView.ViewHolder(itemview)
{
     var txt1:TextView
     var txt2:TextView

    init {

        txt1 = itemview.findViewById(R.id.txt1)
        txt2 = itemview.findViewById(R.id.txt2)

    }
}