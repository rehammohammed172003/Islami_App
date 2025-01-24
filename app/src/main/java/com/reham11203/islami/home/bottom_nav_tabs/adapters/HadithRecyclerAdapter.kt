package com.reham11203.islami.home.bottom_nav_tabs.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.reham11203.islami.databinding.HadithItemBinding
import com.reham11203.islami.home.bottom_nav_tabs.models.Hadith

class HadithRecyclerAdapter(val hadithList: List<Hadith>) :
    RecyclerView.Adapter<HadithRecyclerAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemBinding =
            HadithItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(itemBinding)
    }

    override fun getItemCount(): Int = hadithList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val hadith = hadithList[position]
        holder.bind(hadith)
    }


    class ViewHolder(val itemBinding: HadithItemBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {

        fun bind(hadith: Hadith) {
            itemBinding.hadithTitle.text = hadith.title
            itemBinding.hadithContent.text = hadith.content
        }
    }

}