package com.reham11203.islami.home.bottom_nav_tabs.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.reham11203.islami.R
import com.reham11203.islami.databinding.FragmentTasbehBinding

class TasbehFragment : Fragment() {

    lateinit var binding: FragmentTasbehBinding
    lateinit var azkarList: MutableList<String>
    private var currentIndex = 0
    private var counter = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTasbehBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        azkarList = resources.getStringArray(R.array.azkar_list).toMutableList()
        initView()
        onSebhaClick()
    }

    private fun onSebhaClick() {
        binding.sebhaBody.setOnClickListener {
            binding.sebhaBody.rotation += (360 / 33).toFloat()

            if (counter < 33)
                counter++
            else {
                counter = 0
                currentIndex = if (currentIndex < azkarList.size - 1) ++currentIndex else 0
                binding.zikrTv.text = azkarList[currentIndex]
            }
            binding.counterTv.text = "$counter"

        }
    }

    private fun initView() {
        binding.zikrTv.text = azkarList[currentIndex]
        binding.counterTv.text = "$counter"
    }

}