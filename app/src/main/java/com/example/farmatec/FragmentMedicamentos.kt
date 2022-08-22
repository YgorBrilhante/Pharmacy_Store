package com.example.farmatec

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.farmatec.databinding.FragmentMedicamentosBinding
import com.example.farmatec.databinding.FragmentSuplementosBinding

class FragmentMedicamentos : Fragment() {

    private lateinit var binding: FragmentMedicamentosBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentMedicamentosBinding.inflate(layoutInflater)
        val view = binding.root
    }
}