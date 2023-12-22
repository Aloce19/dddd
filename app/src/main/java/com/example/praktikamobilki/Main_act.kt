package com.example.praktikamobilki

import android.annotation.SuppressLint
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.smarthouse.CustomAdapterRoom
import com.example.smarthouse.DataClass
import org.w3c.dom.Text

class Main_act : ComponentActivity() {
    val st = SBObject.getClient()
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_act)

        findViewById<ImageButton>(R.id.ClickAddRoom).setOnClickListener(){
            val intent = Intent(this@Main_act,AddRoomActivity::class.java)
            startActivity(intent)
        }
        setDAta()
        val adr = findViewById<TextView>(R.id.adr)
        var settings: SharedPreferences = getSharedPreferences("TEST_ADRESS", MODE_PRIVATE)
        val name = settings.getString("TEST_ADD", "не определено")
        adr.text = name
        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
     //   recyclerView.layoutManager = LinearLayoutManager(this)


        val adapter = CustomAdapterRoom(SaveData.roomUser);
        recyclerView.adapter = adapter;
        adapter.notifyDataSetChanged();

        findViewById<ImageButton>(R.id.prof).setOnClickListener(){
            val intent = Intent(this@Main_act, Profile::class.java)
            startActivity(intent)
        }
    }

    fun setDAta(){
        if(SaveData.roomUser.size == 0)
        {
            SaveData.roomUser.add(DataClass.RoomsUsers(arrayImage().arrayRoom()[1],1,"adsada","Кухня"))
        }
    }

}