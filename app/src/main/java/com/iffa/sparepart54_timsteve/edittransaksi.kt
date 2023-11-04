package com.iffa.sparepart54_timsteve

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.iffa.sparepart54_timsteve.databinding.ActivityEdittransaksiBinding

class edittransaksi : AppCompatActivity() {
    lateinit var binding: ActivityEdittransaksiBinding
    var kodeTran = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEdittransaksiBinding.inflate(layoutInflater)
        setContentView(binding.root)
        kodeTran = intent.getIntExtra("id", 0)
        binding.masukkanUsername.setText(kodeTran.toString())


    }
}