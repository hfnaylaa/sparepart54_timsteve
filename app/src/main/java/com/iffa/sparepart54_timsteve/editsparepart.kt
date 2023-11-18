package com.iffa.sparepart54_timsteve

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.iffa.sparepart54_timsteve.databinding.ActivityEditsparepartBinding

class editsparepart : AppCompatActivity() {
    private lateinit var bindroot: ActivityEditsparepartBinding
    var kodepart = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindroot = ActivityEditsparepartBinding.inflate(layoutInflater)
        setContentView(bindroot.root)
        kodepart = intent.getIntExtra("id",0)
        bindroot.editkode.setText(kodepart.toString())
    }
}