package com.iffa.sparepart54_timsteve.roomsteve

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface transaksiDAO {
    @Insert
    fun simpandata_transaksi(transaksi: Transaksi)
    @Update
    fun ubahdata_transaksi(transaksi: Transaksi)
    @Delete
    fun hapusdata_transaksi(transaksi: Transaksi)
    @Query("Select* from tbtransaksi")
    fun tampildata_transaksi () : List<transaksiDAO>
}