package com.iffa.sparepart54_timsteve

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.iffa.sparepart54_timsteve.databinding.ActivityRecycleVwBinding
import com.iffa.sparepart54_timsteve.roomsteve.Sparepart54

class recycle_vw : AppCompatActivity() {

    private lateinit var findbind: ActivityRecycleVwBinding
    private lateinit var adapter1: Sparepart54
    private val db by lazy { Sparepart54(this,) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        findbind = ActivityRecycleVwBinding.inflate(layoutInflater)
        setContentView(findbind.root)
    }
}