package com.iffa.sparepart54_timsteve

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.iffa.sparepart54_timsteve.databinding.ActivityDashboardBinding
import com.iffa.sparepart54_timsteve.roomsteve.Transaksi

class Dashboard : AppCompatActivity() {

    private lateinit var find : ActivityDashboardBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        find = ActivityDashboardBinding.inflate(layoutInflater)
        setContentView(find.root)

        find.Transaksi.setOnClickListener {
            startActivity(
                Intent(this,inptransaksi::class.java))
        }
        find.Sparepart.setOnClickListener {
            startActivity(
                Intent(this,inptsparepart::class.java))
        }
    }
}