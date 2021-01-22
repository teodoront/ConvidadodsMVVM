package com.example.convidados.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.convidados.model.ConvidadoModel
import com.example.convidados.repositorios.ConvidadoRepositorio


class ConvidadosViewModel(application: Application) : AndroidViewModel(application) {

    private val mGuestRepository = ConvidadoRepositorio(application.applicationContext)

    private val mGuestList = MutableLiveData<List<ConvidadoModel>>()
    val guestList: LiveData<List<ConvidadoModel>> = mGuestList

    fun load(filter: Int) {


    }

    fun delete(id: Int) {
        val convidado = mGuestRepository.get(id)
        mGuestRepository.delete(convidado)
    }

}