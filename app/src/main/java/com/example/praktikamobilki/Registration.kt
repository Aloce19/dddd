package com.example.praktikamobilki

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.activity.ComponentActivity
import androidx.lifecycle.lifecycleScope
import io.github.jan.supabase.gotrue.gotrue
import io.github.jan.supabase.gotrue.providers.builtin.Email
import kotlinx.coroutines.launch

class Registration: ComponentActivity() {
    val st = SBObject.getClient()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.register_activity)

    }

     fun Reg_teg(view: View) {
        val em = findViewById<EditText>(R.id.mail)
        val pass = findViewById<EditText>(R.id.pass)
        val name = findViewById<EditText>(R.id.user_name)

        if (pass.length() == 6 && pass.toString() !== "" && em.toString() !== ""
            && name.toString() !== " ")
        {
            lifecycleScope.launch {
                val intent = Intent(this@Registration, Add_pin::class.java)
                st.gotrue.signUpWith(Email) {
                    email = em.text.toString()
                    password = pass.text.toString()

                }
                startActivity(intent)
            }

        }
    }
    fun main_act(view: View) {
        val intent = Intent(this@Registration, Autorezetion::class.java)
        startActivity(intent)
    }
}

