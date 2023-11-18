package com.iffa.sparepart54_timsteve

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.iffa.sparepart54_timsteve.databinding.ActivityLoginBinding

class Login : AppCompatActivity() {
    private lateinit var find : ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        find = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(find.root)

        val sharedPreferences = getSharedPreferences("Datauser",Context.MODE_PRIVATE)

        val inuser = find.masukkanUsername
        val inpass = find.masukkanPassword
        val password = "12345"
        val user = listOf<String>("penjual","pembeli")

        val keyUser = sharedPreferences.getString("username", "")

        if (!keyUser.isNullOrEmpty()) {
            login(keyUser)
        }


        find.btnlogin.setOnClickListener{

            if (inuser.text.isNotEmpty() && inpass.text.isNotEmpty()) {
                if (inpass.text.length >= 8) {

                    login(inuser.text.toString())

                    } else {
                        alert("password minimal 8 huruf")
                    }
                } else {
                    alert("password atau username tidak boleh kosong")
                }
            }
        }
    private fun login(toString: String) {
       startActivity(
           Intent(this,Dashboard::class.java)
               .putExtra("username",toString)
       )
        alert("Selamat Datang di Sparepart54")
         finish()
    }


    private fun alert(msg: String) {
        Toast.makeText(this,msg, Toast.LENGTH_SHORT).show()
    }

}