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
        val user = listOf<String>("penjual","pembeli")
        find.signIn.setOnClickListener{

            if (inuser.text.isNotEmpty() && inpass.text.isNotEmpty()){
                if (inpass.text.length >= 8){

                    if (inuser.text.toString() in user && inpass.text.toString() == password){
                        startActivity(
                            Intent(this, Dashboard::class.java)
                                .putExtra("username", inuser.text.toString())
                        )
                        alert("selamat datang di Part54 ${inuser.text}")
                        finish()
                    } else {
                        alert("pasword atu username salah")
                    }
            } else {
                alert("pasword minnimal 8 huruf")
            }
        } else {
            alert("ojo di kosongi mas!")
        }
    }
}

    private fun alert(msg: String) {
        Toast.makeText(this,msg, Toast.LENGTH_SHORT).show()
    }
}