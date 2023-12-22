package com.example.praktikamobilki

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.lifecycleScope
import com.example.praktikamobilki.R
import io.github.jan.supabase.gotrue.gotrue
import io.github.jan.supabase.gotrue.providers.builtin.Email
import kotlinx.coroutines.launch

class Autorezetion : ComponentActivity() {

    val st = SBObject.getClient()
    val emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\$"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.autorization)

    }


    fun Reg_Auto(view: View){
        val intent = Intent(this@Autorezetion, Registration::class.java)
        startActivity(intent)
    }

    fun Vhod_autorez( view: View){

        val text = "Почта введена неверно"
        val pstxt = "Неверный пароль"
        val tt = Toast.LENGTH_SHORT
        val pass = findViewById<EditText>(R.id.password_auto).text
        val em = findViewById<EditText>(R.id.email_auto).text

        if((pass.length == 6) && (pass.toString() !== "")){
            if(em.toString() !== "" /*&& isValidEmail(emailRegex*/) {
                lifecycleScope.launch {
                    val intent = Intent(this@Autorezetion, Adress::class.java)
                    st.gotrue.loginWith(Email) {
                        email = "t@e.r"
                        password = "123456"

                    }
                    startActivity(intent)
                }



            }
            else{
                val toast = Toast.makeText(applicationContext, text, tt)
                toast.show()
            }
        }
        else   {
            val toast = Toast.makeText(applicationContext, pstxt, tt)
            toast.show()
        }

    }
    fun isValidEmail(email: String): Boolean {
        return email.matches(emailRegex.toRegex())
    }
}