package com.example.praktikamobilki

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText

import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView

import android.widget.ImageButton
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import com.example.smarthouse.DataClass
import kotlinx.coroutines.launch


class AddRoomActivity : AppCompatActivity() {

    private var idRoom: Int = 0;

    lateinit var context: Context;

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_room)
        context = this;
        val btnBack: ImageButton = findViewById(R.id.btnBack1)

        btnBack.setOnClickListener(){
                //AllDataFromBase.RoomUser.add(DataClass.RoomsUsers(3,1,AllDataFromBase.User.id,"dadasd"))
            val intentus = Intent(this, Main_act::class.java)
            startActivity(intentus)
            finish()
        }


        val addRoom: Button = findViewById(R.id.saveAddRoom)
        addRoom.setOnClickListener() {
            lifecycleScope.launch {
                insertData();
            }

        }


    }

    @SuppressLint("WrongViewCast")
    suspend fun insertData()
    {

        val name1: EditText = findViewById(R.id.nameRoom1)
        if(name1.text.toString().length < 3)
        {
            Toast.makeText(this, "Минимальная длина - 3 символа", Toast.LENGTH_LONG).show()
            return
        }

        SaveData.roomUser.add(DataClass.RoomsUsers(SaveData.roomUser.get(SaveData.roomUser.lastIndex).id++, idRoom,"dsadas",findViewById<EditText>(R.id.nameRoom1).text.toString()))


        val intentus = Intent(this, Main_act::class.java)
        startActivity(intentus)
        finish()
    }
    @SuppressLint("ResourceAsColor", "UseCompatLoadingForDrawables")
    fun turnOffAll()
    {
        val enumRooms = ArrayList<ImageView>();
        val enumRoomText = ArrayList<TextView>();
        enumRooms.add(findViewById(R.id.img1))
        enumRooms.add(findViewById(R.id.img2))
        enumRooms.add(findViewById(R.id.img3))
        enumRooms.add(findViewById(R.id.img4))
        enumRooms.add(findViewById(R.id.img5))
        enumRooms.add(findViewById(R.id.img6))

        enumRoomText.add(findViewById(R.id.txt1))
        enumRoomText.add(findViewById(R.id.txt2))
        enumRoomText.add(findViewById(R.id.txt3))
        enumRoomText.add(findViewById(R.id.txt4))
        enumRoomText.add(findViewById(R.id.txt5))
        enumRoomText.add(findViewById(R.id.txt6))

        for (i in 0  until  enumRooms.size)
        {
            enumRooms[i].setBackground(resources.getDrawable(R.drawable.button_circle_gray))
        }
        for (i in 0  until  enumRoomText.size)
        {
            enumRoomText[i].setTextColor(R.color.gray)
        }

    }

    @SuppressLint("ResourceAsColor", "UseCompatLoadingForDrawables")
    fun onRoomSelect(view: View)
    {
        turnOffAll()
        when(view.id) {

            R.id.img1 ->  {findViewById<ImageView>(R.id.img1).setBackground(resources.getDrawable(R.drawable.button_circle_blue));findViewById<TextView>(R.id.txt4).setTextColor(R.color.blue); idRoom = 0}
            R.id.img2 -> {findViewById<ImageView>(R.id.img2).setBackground(resources.getDrawable(R.drawable.button_circle_blue)); findViewById<TextView>(R.id.txt4).setTextColor(R.color.blue); idRoom = 1}
            R.id.img3 -> {findViewById<ImageView>(R.id.img3).setBackground(resources.getDrawable(R.drawable.button_circle_blue)); findViewById<TextView>(R.id.txt4).setTextColor(R.color.blue); idRoom = 2}
            R.id.img4 -> {findViewById<ImageView>(R.id.img4).setBackground(resources.getDrawable(R.drawable.button_circle_blue)); findViewById<TextView>(R.id.txt4).setTextColor(R.color.blue); idRoom = 3}
            R.id.img5 -> {findViewById<ImageView>(R.id.img5).setBackground(resources.getDrawable(R.drawable.button_circle_blue)); findViewById<TextView>(R.id.txt4).setTextColor(R.color.blue); idRoom = 4}
            R.id.img6 -> {findViewById<ImageView>(R.id.img6).setBackground(resources.getDrawable(R.drawable.button_circle_blue)); findViewById<TextView>(R.id.txt4).setTextColor(R.color.blue); idRoom = 5}

        }
    }
}