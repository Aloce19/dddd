package com.example.praktikamobilki

import android.annotation.SuppressLint
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.activity.ComponentActivity

class Adress : ComponentActivity() {
    val st = SBObject.getClient()
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.add_email)


    }

    fun Go_main(view : View){
        val adres = findViewById<EditText>(R.id.user_adress).text

        if(adres.toString() !== ""){
            var settings: SharedPreferences = getSharedPreferences("TEST_ADRESS", MODE_PRIVATE);
            val prefEditor = settings.edit()
            prefEditor.putString("TEST_ADD", adres.toString())
            prefEditor.apply()
            val intent = Intent(this@Adress, Main_act::class.java)
            startActivity(intent)
        }
    }
}