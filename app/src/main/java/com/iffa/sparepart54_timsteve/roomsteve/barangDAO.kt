package com.iffa.sparepart54_timsteve.roomsteve

import androidx.room.*

@Dao
interface barangDAO {
    @Insert
    fun simpan_databarang(barang: Barang)
    @Update
    fun ubah_databarang(barang: Barang)
    @Delete
    fun hapus_databarang(barang: Barang)
    @Query("Select* from tbbarang")
    fun tampil_databarang () : List<barangDAO>
}