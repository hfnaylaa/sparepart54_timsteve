package com.iffa.sparepart54_timsteve

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.iffa.sparepart54_timsteve.databinding.ActivityInptransaksiBinding
import com.iffa.sparepart54_timsteve.roomsteve.Barang
import com.iffa.sparepart54_timsteve.roomsteve.Sparepart54
import com.iffa.sparepart54_timsteve.roomsteve.Transaksi
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class inptransaksi : AppCompatActivity() {
    private lateinit var binding: ActivityInptransaksiBinding
    private lateinit var database : Sparepart54

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInptransaksiBinding.inflate(layoutInflater)
        setContentView(binding.root)

        database = Sparepart54.invoke(applicationContext)
        binding.inpttrans.setOnClickListener {
            this.insertTransaksi()
        }
    }

    private fun insertTransaksi() {
        CoroutineScope(Dispatchers.IO).launch {
            database.partdao().simpandata_transaksi(
                Transaksi(
                    0,

                    binding.namabrg.text.toString(),
                    binding.jumlahbrg.text.toString().toInt(),
                    binding.hargabrg.text.toString().toInt()
                )
            )

            binding.namabrg.setText("")
            binding.jumlahbrg.setText("")
            binding.hargabrg.setText("")
        }
        binding.inpttrans.setOnClickListener{
            startActivity(Intent(this,recycletransaksi::class.java))
        }
    }
}