package com.example.convidados.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.convidados.R
import com.example.convidados.viewmodel.PresentesViewModel

class PresentesFragment : Fragment() {

  private lateinit var presentesViewModel: PresentesViewModel

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    presentesViewModel =
            ViewModelProvider(this).get(PresentesViewModel::class.java)
    val root = inflater.inflate(R.layout.fragment_presents, container, false)
    val textView: TextView = root.findViewById(R.id.text_presentes)
    presentesViewModel.text.observe(viewLifecycleOwner, Observer {
      textView.text = it
    })
    return root
  }
}