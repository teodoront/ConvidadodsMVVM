package com.example.convidados.repositorios

import android.content.Context
import com.example.convidados.model.ConvidadoModel

class ConvidadoRepositorio(context: Context) {

    private val mDataBase = ConvidadoBD.getDatabase(context).convidadoDAO()

    fun get(id: Int): ConvidadoModel{
        return mDataBase.load(id)
    }


    fun getTodos(): List<ConvidadoModel> {
        return mDataBase.getTodos()
    }

    fun getPresentes(): List<ConvidadoModel> {
        return mDataBase.getPresente()
    }

    fun getAusentes(): List<ConvidadoModel> {
        return mDataBase.getAusente()
    }

    //CRUD

    fun save(convidadoModel: ConvidadoModel): Boolean {
        return mDataBase.save(convidadoModel) > 0

    }

    fun update(convidadoModel: ConvidadoModel): Boolean {
        return mDataBase.update(convidadoModel) > 0

    }

    fun delete(convidadoModel: ConvidadoModel) {
        mDataBase.delete(convidadoModel)
    }

}