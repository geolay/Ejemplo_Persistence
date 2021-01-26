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
            var capturaeditt=mbinding.ingresaEntero.text.toString().toInt()
            spreference.edit().putInt("claveint",capturaeditt).apply()
        }

        mbinding.textView.text=spreference.getInt("claveint",0).toString()

    }
}