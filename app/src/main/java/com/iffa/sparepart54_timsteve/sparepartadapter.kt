package com.iffa.sparepart54_timsteve

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.iffa.sparepart54_timsteve.roomsteve.Barang
import com.iffa.sparepart54_timsteve.roomsteve.Transaksi

class sparepartadapter(var list: ArrayList<Barang>, var listener: onClickListener) :
    RecyclerView.Adapter<sparepartadapter.SparepartHolder>() {
    class SparepartHolder(view: View) : RecyclerView.ViewHolder(view) {
        val KodePart = itemView.findViewById<TextView>(R.id.kodepart)
        val NamaPart = itemView.findViewById<TextView>(R.id.namapart)
        val StokPart = itemView.findViewById<TextView>(R.id.stokpart)
        val DeskPart = itemView.findViewById<TextView>(R.id.deskpart)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SparepartHolder {
        return SparepartHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.adaptersparepart, parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: SparepartHolder, position: Int) {
        holder.KodePart.text = list[position].kode_barang.toString()
        holder.NamaPart.text = list[position].nama_barang
        holder.StokPart.text = list[position].stok_barang.toString()
        holder.DeskPart.text = list[position].deskripsi_barang
    }

    override fun getItemCount(): Int {
        return list.size
    }

    interface onClickListener {
        fun onClick(transaksi: Transaksi)
    }
}