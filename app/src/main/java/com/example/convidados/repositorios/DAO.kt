package com.example.convidados.repositorios

import androidx.room.*
import com.example.convidados.model.ConvidadoModel

@Dao
interface DAO {

    @Insert
    fun save(convidado: ConvidadoModel): Long

    @Update
    fun update(convidado: ConvidadoModel): Int

    @Delete
    fun delete(convidado: ConvidadoModel)



    @Query("select * from convidado where id = :id")
    fun load(id: Int) : ConvidadoModel

    @Query("select * from convidado")
    fun getTodos(): List<ConvidadoModel>

    @Query("select * from convidado where id = 1")
    fun getPresente() : List<ConvidadoModel>

    @Query("select * from convidado where id = 0")
    fun getAusente() : List<ConvidadoModel>

}