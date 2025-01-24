package com.reham11203.islami.home.bottom_nav_tabs.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.reham11203.islami.databinding.FragmentRadioBinding


class RadioFragment : Fragment() {
    lateinit var binding: FragmentRadioBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRadioBinding.inflate(inflater, container, false)
        return binding.root
    }

}