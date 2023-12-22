package com.example.smarthouse

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.recyclerview.widget.RecyclerView
import com.example.praktikamobilki.R
import com.example.praktikamobilki.arrayImage
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlin.concurrent.thread

class CustomAdapterRoom (private  var data: ArrayList<DataClass.RoomsUsers>):
            RecyclerView.Adapter<CustomAdapterRoom.ViewHolder>(){

                class ViewHolder(itemView: View, private val listener:View.OnClickListener):
                    RecyclerView.ViewHolder(itemView),View.OnClickListener{
                    var name: TextView = itemView.findViewById(R.id.roomName);
                    var img: ImageView = itemView.findViewById(R.id.roomImg);
                    init {
            itemView.setOnClickListener(this)
        }
        @OptIn(DelicateCoroutinesApi::class)
        override fun onClick(v: View?) {
             listener.onClick(v);
           // val intent = Intent(v?.context, DeviceActivity::class.java)
           // v?.context?.startActivity(intent);
        }
    }

    override fun onBindViewHolder(holder: ViewHolder,position: Int){
        holder.name.text = data[position].name.toString();
        holder.img.setBackgroundResource(arrayImage().arrayRoom()[data[position].idRoom])
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.custom_layout_room, parent, false)
        return ViewHolder(view, View.OnClickListener {})
    }

    override fun getItemCount(): Int {
        return data.size
    }
}

