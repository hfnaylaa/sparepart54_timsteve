package com.iffa.sparepart54_timsteve

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

        val inuser = find.masukkanUsername
        val inpass = find.masukkanPassword
        val password = "12345"
        val user = listOf<String>("Penjual", "Pembeli")
        find.signin.setOnClickListener {


            if (inuser.text.isNotEmpty() && inpass.text.isNotEmpty()) {
                if (inpass.text.length >= 8) {


                    if (inuser.text.toString() in user && inpass.text.toString() == password) {
                        startActivity(
                            Intent(this, Dashboard::class.java)
                                .putExtra("username", inuser.text.toString())
                        )
                        alert("Selamat datang di Go-Rent ${inuser.text}")
                        finish()
                    } else {
                        alert("pasword atau username salah")
                    }
                } else {
                    alert("Pasword minimal 8 huruf")
                }

            } else {
                alert("Username dan Password tidak boleh kosong!")
            }
        }

    }

            private fun alert(msg: String) {

                Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()


    }
}