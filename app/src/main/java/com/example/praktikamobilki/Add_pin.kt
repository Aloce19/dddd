package com.example.praktikamobilki

import android.R.attr.name
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.ComponentActivity


class Add_pin : ComponentActivity() {
    var value = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.win_pin_code)
        val st = SBObject.getClient()

       // val mySharedPreferences = getSharedPreferences(APP_PREFERENCE, MODE_PRIVATE)
    }


    fun onPINClick(v: View) {
        when (v.id) {
            R.id.bt_one -> value = value + 1
            R.id.bt_two -> value = value  + 2
            R.id.bt_three -> value = value  + 3
            R.id.bt_four -> value = value  + 4
            R.id.bt_five -> value = value  + 5
            R.id.bt_six -> value = value  + 6
            R.id.bt_seven -> value = value  + 7
            R.id.bt_eight -> value = value  + 8
            R.id.bt_nine -> value = value  + 9
        }
        if (value.length == 4) {

            var settings: SharedPreferences  = getSharedPreferences("TEST_FILE", MODE_PRIVATE);
            val prefEditor = settings.edit()
            prefEditor.putString("TEST_PIN", value)
            prefEditor.apply()
            val intent = Intent(this@Add_pin, Win_pin_code::class.java)
            startActivity(intent)
        }

    }
}