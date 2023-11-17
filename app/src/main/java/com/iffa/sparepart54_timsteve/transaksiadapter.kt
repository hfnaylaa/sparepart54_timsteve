package com.iffa.sparepart54_timsteve

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.iffa.sparepart54_timsteve.roomsteve.Transaksi

class transaksiadapter(val list: ArrayList<Transaksi>, var Listener: Any) :
RecyclerView.Adapter<transaksiadapter.TransaksiHolder>(){
    class TransaksiHolder(view: View) : RecyclerView.ViewHolder(view){
        val kode = itemView.findViewById<TextView>(R.id.kodets)
        val nama = itemView.findViewById<TextView>(R.id.namabrgts)
        val jumlah = itemView.findViewById<TextView>(R.id.jumlahbrgts)
        val harga = itemView.findViewById<TextView>(R.id.hargabrgts)
        val hapus = itemView.findViewById<Button>(R.id.btnhaputs)
        val edit = itemView.findViewById<Button>(R.id.btneditts)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TransaksiHolder {
        return TransaksiHolder(
            LayoutInflater.from(parent.context)
                .inflate(
                    R.layout.adaptertransaksi,
                    parent,
                    false
                )
        )
    }

    override fun onBindViewHolder(holder: TransaksiHolder, position: Int) {
        holder.kode.text = list[position].kode_Transaksi.toString()
        holder.nama.text = list[position].nama_Transaksi.toString()
        holder.jumlah.text = list[position].jumlah_Transaksi.toString()
        holder.harga.text = list[position].harga_Transaksi.toString()




    }

    override fun getItemCount(): Int {
        return list.size
    }

    interface OnClickListener{
        fun onCreate(transaksi: Transaksi)
        fun onDelete(transaksi: Transaksi)
    }

}

