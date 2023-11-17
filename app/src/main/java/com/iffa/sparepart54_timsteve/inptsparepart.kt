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
        binding.inputpart.setOnClickListener{
            if (binding.kodepart.text.isNotEmpty() &&
                binding.namapart.text.isNotEmpty() &&
                binding.stokpart.text.isNotEmpty() &&
                binding.deskripsipart.text.isNotEmpty()
            ){
                database.partdao().simpan_databarang(Barang(
                    binding.kodepart.text.toString().toInt(),
                    binding.namapart.text.toString(),
                    binding.stokpart.text.toString().toInt(),
                    binding.deskripsipart.text.toString()
                ))

                binding.kodepart.setText("")
                binding.namapart.setText("")
                binding.stokpart.setText("")
                binding.deskripsipart.setText("")
                startActivity(
                    Intent(this,Dashboard::class.java)
                )
            }
        }
    }
}