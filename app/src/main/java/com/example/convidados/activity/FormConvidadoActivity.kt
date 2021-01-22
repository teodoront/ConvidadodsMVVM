package com.example.convidados.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.convidados.R
import com.example.convidados.viewmodel.ConvidadosFormViewModel

class FormConvidadoActivity : AppCompatActivity() {

    private lateinit var mFormViewModel: ConvidadosFormViewModel //vou tratar as regras de negócios aqui


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form_convidado)

        mFormViewModel = ViewModelProvider(this).get(ConvidadosFormViewModel::class.java)


        setListeners()
        observe()

    }

    private fun setListeners() {
        //Vai escutar os eventos de clique do botão salvar
        val btnSalvar = findViewById<Button>(R.id.btn_salvar)
        btnSalvar.setOnClickListener {
            val nome = findViewById<EditText>(R.id.edt_nome).text.toString()
            val presenca = findViewById<CheckBox>(R.id.radio_confirmado).isChecked

            mFormViewModel.salvar(0, nome, presenca)
        }
    }


    private fun observe() {
        mFormViewModel.salvaConvidado.observe(this, Observer {
            if (it){
                Toast.makeText(applicationContext, "Sucesso", Toast.LENGTH_LONG).show()
            }else{
                Toast.makeText(applicationContext, "Falha", Toast.LENGTH_LONG).show()
            }
        })
    }



}


