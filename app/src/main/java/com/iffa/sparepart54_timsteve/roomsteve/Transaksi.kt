package com.iffa.sparepart54_timsteve.roomsteve

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tbtransaksi")
data class Transaksi (
    @PrimaryKey
    val kode_Transaksi : Int,
    @ColumnInfo
    val nama_Barang : String,
    @ColumnInfo
    val jumlah_Barang : Int,
    @ColumnInfo
    val harga_Barang : Int

        )