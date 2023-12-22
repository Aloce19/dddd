package com.example.praktikamobilki

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import androidx.activity.ComponentActivity

class Win_pin_code : ComponentActivity() {
    val st = SBObject.getClient()
    var value = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.vvod_pin_code)

        val intent = Intent(this@Win_pin_code, Adress::class.java)
        //startActivity(intent)
    }
    fun onPINClickW(v: View){
        var settings: SharedPreferences = getSharedPreferences("TEST_FILE", MODE_PRIVATE)
        val name = settings.getString("TEST_PIN", "не определено")



        when(v.id){
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
        if (value.length == 4 ){
            if (value == name){
                val intent = Intent(this@Win_pin_code, Adress::class.java)
                startActivity(intent)
            } else{
                value = ""
            }

        }


    }


}