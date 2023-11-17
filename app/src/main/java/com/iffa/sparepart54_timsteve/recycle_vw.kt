package com.iffa.sparepart54_timsteve

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.iffa.sparepart54_timsteve.databinding.ActivityRecycleVwBinding
import com.iffa.sparepart54_timsteve.roomsteve.Sparepart54
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class recycle_vw : AppCompatActivity() {

    private lateinit var binding: ActivityRecycleVwBinding
    private lateinit var adapter: sparepartadapter
    private val db by lazy { Sparepart54.invoke(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecycleVwBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.floatPart.setOnClickListener{
            startActivity(Intent(this, inptsparepart::class.java))
        }

        adapter = sparepartadapter(arrayListOf())
    }

    override fun onResume() {
        super.onResume()
        showData()
    }

    private fun showData() {
        binding.recyclerpart.layoutManager = LinearLayoutManager(this)
        CoroutineScope((Dispatchers.IO)).launch {
            adapter.setData(db.partdao().tampil_databarang())
            withContext(Dispatchers.Main){
                adapter.notifyDataSetChanged()
            }
        }
        binding.recyclerpart.adapter = adapter
    }
}