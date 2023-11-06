package com.iffa.sparepart54_timsteve

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.iffa.sparepart54_timsteve.databinding.ActivityInptransaksiBinding
import com.iffa.sparepart54_timsteve.roomsteve.Sparepart54
import com.iffa.sparepart54_timsteve.roomsteve.Transaksi
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class inptransaksi : AppCompatActivity() {

    private lateinit var binding : ActivityInptransaksiBinding
    private val db by lazy { Sparepart54(this) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInptransaksiBinding.inflate(layoutInflater)
        setContentView(binding.root)
        this.simpandata_transaksi()
    }
    private fun simpandata_transaksi() {
        binding.inputtrans.setOnClickListener {
        CoroutineScope(Dispatchers.IO).launch {
            db.transaksidao().simpandata_transaksi(
                Transaksi(
                    kode_Transaksi = binding.kodetrans.text.toString().toInt(),
                    nama_Barang = binding.namabarang.text.toString(),
                    jumlah_Barang = binding.jumlahbarang.text.toString().toInt(),
                    harga_Barang = binding.hargabarang.text.toString().toInt()
                )
            )
        }
        startActivity(Intent(this,recycle_vw::class.java))
        }
    }
}