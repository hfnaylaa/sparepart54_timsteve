package com.iffa.sparepart54_timsteve

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import androidx.viewbinding.BuildConfig
import com.iffa.sparepart54_timsteve.databinding.ActivityMainBinding
import com.iffa.sparepart54_timsteve.roomsteve.Sparepart54

class MainActivity : AppCompatActivity() {

    private lateinit var find :ActivityMainBinding
    private val db by lazy { Sparepart54.invoke(this) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        find = ActivityMainBinding.inflate(layoutInflater)
        setContentView(find.root)

        Handler().postDelayed({
            startActivity(Intent(this,Login::class.java))
            finish()
        },2000)

    }
}