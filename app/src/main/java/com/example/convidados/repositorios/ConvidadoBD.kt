package com.example.convidados.repositorios

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.convidados.model.ConvidadoModel


@Database(entities = [ConvidadoModel::class], version = 1)
abstract class ConvidadoBD : RoomDatabase() {

    abstract fun convidadoDAO(): DAO

    companion object {
        private lateinit var INSTANCE: ConvidadoBD
        fun getDatabase(context: Context): ConvidadoBD{
            if (!:: INSTANCE.isInitialized){
                synchronized(ConvidadoBD::class.java){

                    INSTANCE = Room.databaseBuilder(context, ConvidadoBD::class.java, "convidadoBd")
                        .allowMainThreadQueries()
                        .build()
                }
            }
            return INSTANCE
        }

        /**
         * Atualização de versão de banco de dados
         */
        private val MIGRATION_1_2: Migration = object : Migration(1, 2) {
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL("DELETE FROM Guest")
            }
        }
    }
}