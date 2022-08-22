package com.example.farmatec

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.farmatec.databinding.FragmentEsteticaBinding

class FragmentEstetica : Fragment() {

    private lateinit var binding: FragmentEsteticaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentEsteticaBinding.inflate(layoutInflater)
        val view = binding.root
    }

}
