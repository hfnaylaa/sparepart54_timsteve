package com.iffa.sparepart54_timsteve.roomsteve

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Barang::class,Transaksi::class], version = 1)
abstract class Sparepart54: RoomDatabase() {
    abstract fun barangdao(): barangDAO
    abstract fun transaksidao(): transaksiDAO

    companion object{
        @Volatile
        private var instance : Sparepart54? = null
        private val Lock = Any()

        operator fun invoke(context: Context) = instance?: synchronized(Lock){
            instance?: buildDatabase(context).also {
                instance = it
            }
        }
        private fun buildDatabase(context: Context) = Room.databaseBuilder(
            context.applicationContext,Sparepart54::class.java, "sparepart54"
        ).fallbackToDestructiveMigration().build()
    }
}