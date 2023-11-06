package com.iffa.sparepart54_timsteve

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.iffa.sparepart54_timsteve.databinding.ActivityDashboardBinding

class Dashboard : AppCompatActivity() {

    private  lateinit var  find :ActivityDashboardBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        find = ActivityDashboardBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_dashboard)
        setContentView(find.root)

        find.Transaksi.setOnClickListener{
            startActivity(Intent(this,inptsparepart::class.java))
        }
    }
}