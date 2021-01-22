package com.example.convidados.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AusentesViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Ausentes"
    }
    val text: LiveData<String> = _text
}