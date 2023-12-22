package com.example.praktikamobilki

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.praktikamobilki.R
import com.example.praktikamobilki.SBObject
import com.example.smarthouse.CustomAdapterRoom

class Profile : ComponentActivity() {
    val st = SBObject.getClient()

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.profile)

    }
}