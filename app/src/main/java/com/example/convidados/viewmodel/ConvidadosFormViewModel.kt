package com.example.convidados.viewmodel

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.convidados.model.ConvidadoModel
import com.example.convidados.repositorios.ConvidadoRepositorio

class ConvidadosFormViewModel(application: Application) : ViewModel() {

    //Instanciamento de classes em Kotlin
    private val mContext = application.applicationContext
    private var mConvidadoRepositorio: ConvidadoRepositorio = ConvidadoRepositorio(mContext)


    //Tratar regras de negócios aqui

    private var mSalvaConvidado = MutableLiveData<Boolean>()//Muda valor
    val salvaConvidado: LiveData<Boolean> = mSalvaConvidado //Não muda valor


  fun salvar(id: Int, nome: String, presenca: Boolean) {
        val convidado = ConvidadoModel().apply {
            this.id = id
            this.nome = nome
            this.presenca = presenca
        }

        mConvidadoRepositorio.save(convidado)
    }

}