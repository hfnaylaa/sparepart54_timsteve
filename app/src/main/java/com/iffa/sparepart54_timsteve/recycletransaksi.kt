package com.iffa.sparepart54_timsteve

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.iffa.sparepart54_timsteve.databinding.ActivityRecycletransaksiBinding
import com.iffa.sparepart54_timsteve.roomsteve.Sparepart54
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class recycletransaksi : AppCompatActivity() {

    private lateinit var binding: ActivityRecycletransaksiBinding
    private lateinit var adapter: transaksiadapter
    private val db by lazy { Sparepart54.invoke(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecycletransaksiBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.floadtransaksi.setOnClickListener{
            startActivity(Intent(this, inptsparepart::class.java))
        }

        adapter = transaksiadapter(arrayListOf())
    }

    override fun onResume() {
        super.onResume()
        showData()
    }

    private fun showData() {
        binding.recyclertransaksi.layoutManager = LinearLayoutManager(this)
        CoroutineScope((Dispatchers.IO)).launch {
            adapter.setAll(db.partdao().tampildata_transaksi()  )
            withContext(Dispatchers.Main){
                adapter.notifyDataSetChanged()
            }
        }
        binding.recyclertransaksi.adapter = adapter
    }
}