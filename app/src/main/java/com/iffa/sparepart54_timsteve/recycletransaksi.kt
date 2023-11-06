package com.iffa.sparepart54_timsteve

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.iffa.sparepart54_timsteve.databinding.ActivityRecycletransaksiBinding
import com.iffa.sparepart54_timsteve.roomsteve.Sparepart54
import com.iffa.sparepart54_timsteve.roomsteve.Transaksi
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class recycletransaksi : AppCompatActivity() {

    private lateinit var binding: ActivityRecycletransaksiBinding
    private lateinit var adapter: transaksiadapter
    private val db by lazy { Sparepart54(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecycletransaksiBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = transaksiadapter(arrayListOf(),
            object : transaksiadapter. OnClickListener {
                override fun onCreate(transaksi: Transaksi) {



                }

                override fun onDelete(transaksi: Transaksi) {
                    TODO("Not yet implemented")
                }

            }
        )
        binding.floadtransaksi.setOnClickListener {
            startActivity(
                Intent(this,inptransaksi::class.java)

            )
        }

    }

    override fun onResume() {
        super.onResume()


    }
}