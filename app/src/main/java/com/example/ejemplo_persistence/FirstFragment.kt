package com.example.ejemplo_persistence

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import com.example.ejemplo_persistence.databinding.FragmentFirstBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {
    private lateinit var mbinding: FragmentFirstBinding
    private lateinit var spreference: SharedPreferences

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        mbinding= FragmentFirstBinding.inflate(inflater,container,false)
        spreference= requireActivity().getSharedPreferences("archivodatos",Context.MODE_PRIVATE)
        // Inflate the layout for this fragment
        return mbinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mbinding.botonGuardar.setOnClickListener {
            var capturaedit1=mbinding.ingresaEntero.text.toString().toInt()
            spreference.edit().putInt("claveint",capturaedit1).apply()

            var capturaedit2=mbinding.ingesaTexto.text.toString()
            spreference.edit().putString("clavetexto",capturaedit2).apply()

            var capturaedit3=mbinding.ingresaDecimal.text.toString().toFloat()
            spreference.edit().putFloat("clavedecimal",capturaedit3).apply()
        }
        mbinding.textView.text=spreference.getInt("claveint",0).toString()
        mbinding.textView2.text=spreference.getString("clavetexto","x").toString()
        mbinding.textView3.text=spreference.getFloat("clavedecimal",0f).toString()

        mbinding.botonBorrar.setOnClickListener {
            spreference.edit().remove("claveint").apply()
            spreference.edit().remove("clavetexto").apply()
            spreference.edit().remove("clavedecimal").apply()
            mbinding.ingresaEntero.setText("")
            mbinding.ingesaTexto.setText("")
            mbinding.ingresaDecimal.setText("")
            mbinding.textView.setText("")
            mbinding.textView2.setText("")
            mbinding.textView3.setText("")
        }
    }
}