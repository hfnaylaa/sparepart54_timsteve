package com.iffa.sparepart54_timsteve

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.iffa.sparepart54_timsteve.databinding.ActivityInptsparepartBinding
import com.iffa.sparepart54_timsteve.roomsteve.Barang
import com.iffa.sparepart54_timsteve.roomsteve.Sparepart54
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class inptsparepart : AppCompatActivity() {
    private lateinit var binding: ActivityInptsparepartBinding
    private lateinit var database: Sparepart54

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInptsparepartBinding.inflate(layoutInflater)
        setContentView(binding.root)

        database = Sparepart54.invoke(applicationContext)
        binding.inputpart.setOnClickListener {
            this.insertsparepart()
        }
    }

    private fun insertsparepart() {
        CoroutineScope(Dispatchers.IO).launch {
            database.partdao().simpan_databarang(
                Barang(
                    0,

                    binding.namapart.text.toString(),
                    binding.stokpart.text.toString().toInt(),
                    binding.deskripsipart.text.toString()
                )
            )
            binding.namapart.setText("")
            binding.stokpart.setText("")
            binding.deskripsipart.setText("")

        }
        binding.inputpart.setOnClickListener{
            startActivity(Intent(this,recycle_vw::class.java))
        }
    }
}

