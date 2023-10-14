package com.iffa.sparepart54_timsteve

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.iffa.sparepart54_timsteve.databinding.ActivityInptsparepartBinding
import com.iffa.sparepart54_timsteve.roomsteve.Barang
import com.iffa.sparepart54_timsteve.roomsteve.Sparepart54
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class inptsparepart : AppCompatActivity() {

    private lateinit var binInput : ActivityInptsparepartBinding
    private val db by lazy { Sparepart54(this) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binInput = ActivityInptsparepartBinding.inflate(layoutInflater)
        setContentView(binInput.root)
        binInput.inputpart.setOnClickListener {
            simpan_databarang()
        }
    }

    private fun simpan_databarang(){
        CoroutineScope(Dispatchers.IO).launch {
            db.barangdao().simpan_databarang(
                Barang(
                    binInput.kodepart.text.toString().toInt(),
                    binInput.namapart.text.toString(),
                    binInput.jumlahpart.text.toString().toInt(),
                    binInput.deskripsipart.text.toString()
            ))
            finish()
        }
    }
}