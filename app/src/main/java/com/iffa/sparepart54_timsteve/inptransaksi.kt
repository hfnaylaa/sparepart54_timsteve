package com.iffa.sparepart54_timsteve

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.iffa.sparepart54_timsteve.databinding.ActivityInptransaksiBinding
import com.iffa.sparepart54_timsteve.roomsteve.Sparepart54
import com.iffa.sparepart54_timsteve.roomsteve.Transaksi

class inptransaksi : AppCompatActivity() {
    private lateinit var binding: ActivityInptransaksiBinding
    private lateinit var database : Sparepart54

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInptransaksiBinding.inflate(layoutInflater)
        setContentView(binding.root)

        database = Sparepart54.invoke(applicationContext)
        binding.inpttrans.setOnClickListener {
            if (binding.kodetrans.text.isNotEmpty() &&
                binding.namabrg.text.isNotEmpty() &&
                binding.jumlahbrg.text.isNotEmpty() &&
                binding.hargabrg.text.isNotEmpty()

                ){

                database.partdao().simpandata_transaksi(
                    Transaksi(
                    binding.kodetrans.text.toString().toInt(),
                    binding.namabrg.text.toString(),
                    binding.jumlahbrg.text.toString().toInt(),
                    binding.hargabrg.text.toString().toInt()
                    ))

                binding.kodetrans.setText("")
                binding.namabrg.setText("")
                binding.jumlahbrg.setText("")
                binding.hargabrg.setText("")
                startActivity(
                    Intent(this,recycle_vw::class.java)
                )
            }
        }
    }
}