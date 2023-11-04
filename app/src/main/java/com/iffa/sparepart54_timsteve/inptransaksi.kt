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

    private lateinit var binInput : ActivityInptransaksiBinding
    private val db by lazy { Sparepart54(this) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binInput = ActivityInptransaksiBinding.inflate(layoutInflater)
        setContentView(binInput.root)
        binInput.inputtrans.setOnClickListener{
            simpandata_transaksi()
        }
    }
    private fun simpandata_transaksi() {
        CoroutineScope(Dispatchers.IO).launch {
            db.transaksidao().simpandata_transaksi(
                Transaksi(
                    binInput.kodetrans.text.toString().toInt(),
                    binInput.namabarang.text.toString(),
                    binInput.jumlahbarang.text.toString().toInt(),
                    binInput.hargabarang.text.toString().toInt()
                )
            )
            finish()
        }
        startActivity(Intent(this,recycle_vw::class.java))
    }
}