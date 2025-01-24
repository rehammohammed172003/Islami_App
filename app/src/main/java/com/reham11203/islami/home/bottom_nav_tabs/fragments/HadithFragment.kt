package com.reham11203.islami.home.bottom_nav_tabs.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.mig35.carousellayoutmanager.CarouselLayoutManager
import com.mig35.carousellayoutmanager.CarouselZoomPostLayoutListener
import com.mig35.carousellayoutmanager.CenterScrollListener
import com.reham11203.islami.databinding.FragmentHadithBinding
import com.reham11203.islami.home.bottom_nav_tabs.adapters.HadithRecyclerAdapter
import com.reham11203.islami.home.bottom_nav_tabs.models.Hadith


class HadithFragment : Fragment() {


    lateinit var binding: FragmentHadithBinding
    val ahadith: MutableList<Hadith> = mutableListOf()
    lateinit var adapter: HadithRecyclerAdapter
    lateinit var layoutManager: CarouselLayoutManager

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHadithBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        readAhadithFile()
        initHadithRecycler()

    }

    private fun initHadithRecycler() {
        adapter = HadithRecyclerAdapter(ahadith)
        binding.recyclerHadith.adapter = adapter
        layoutManager = CarouselLayoutManager(CarouselLayoutManager.HORIZONTAL, true)
        binding.recyclerHadith.layoutManager = layoutManager
        binding.recyclerHadith.addOnScrollListener(CenterScrollListener())
        layoutManager.setPostLayoutListener(CarouselZoomPostLayoutListener())


    }

    fun readAhadithFile() {
        val fileContent = activity?.assets?.open("hadith/ahadeth.txt")
            ?.bufferedReader().use { it?.readText() }
        if (fileContent == null) return
        val hadithList = fileContent.trim()
            .split("#")
        hadithList.forEach { hadith ->
            val lines = hadith.trim().split("\n")
            val title = lines[0]
            val content = lines.takeLast(lines.size - 1).joinToString("\n")
            val hadith = Hadith(title, content)
            ahadith.add(hadith)
        }


    }

}