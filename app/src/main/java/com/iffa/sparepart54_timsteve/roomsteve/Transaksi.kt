package com.iffa.sparepart54_timsteve.roomsteve

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tbtransaksi")
data class Transaksi(
    @PrimaryKey
    val kode_Transaksi: Int,
    @ColumnInfo
    val nama_Transaksi: String,
    @ColumnInfo
    val jumlah_Transaksi: Int,
    @ColumnInfo
    val harga_Transaksi: Int,

    )