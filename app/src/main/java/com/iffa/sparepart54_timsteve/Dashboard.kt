package com.iffa.sparepart54_timsteve

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.iffa.sparepart54_timsteve.databinding.ActivityDashboardBinding

class Dashboard : AppCompatActivity() {

    private  lateinit var  splashscreen :ActivityDashboardBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        splashscreen = ActivityDashboardBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_dashboard)
        setContentView(splashscreen.root)

        splashscreen.Transaksi.setOnClickListener{
            startActivity(Intent(this,inptsparepart::class.java))
        }
    }
}