package com.iffa.sparepart54_timsteve.roomsteve

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tbbarang")
data class Barang (
    @PrimaryKey
    val kode_barang : Int,
    @ColumnInfo
    val nama_barang : String,
    @ColumnInfo
    val stok_barang : Int,
    @ColumnInfo
    val deskripsi_barang : String
        )