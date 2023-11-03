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

    private lateinit var binding : ActivityInptsparepartBinding
    private val db by lazy { Sparepart54(this) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInptsparepartBinding.inflate(layoutInflater)
        setContentView(binding.root)
        this.simpan_databarang()
    }

    private fun simpan_databarang(){
        binding.inputpart.setOnClickListener {
        CoroutineScope(Dispatchers.IO).launch {
            db.barangdao().simpan_databarang(
                Barang(
                    kode_barang = binding.kodepart.text.toString().toInt(),
                    nama_barang = binding.namapart.text.toString(),
                    stok_barang = binding.jumlahpart.text.toString().toInt(),
                    deskripsi_barang = binding.deskripsipart.text.toString()
                )
            )
        }
            startActivity(Intent(this,recycle_vw::class.java))
        }
    }
}