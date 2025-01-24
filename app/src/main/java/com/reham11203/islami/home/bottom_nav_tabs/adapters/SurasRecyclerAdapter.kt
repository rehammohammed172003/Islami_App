package com.reham11203.islami.home.bottom_nav_tabs.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.reham11203.islami.databinding.QuranSurahItemBinding
import com.reham11203.islami.home.bottom_nav_tabs.models.Surah

class SurasRecyclerAdapter(val surasList: List<Surah>) :
    RecyclerView.Adapter<SurasRecyclerAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemBinding = QuranSurahItemBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )

        return ViewHolder(itemBinding)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val surah = surasList[position]
        holder.bind(surah)

        onItemClickListener?.let { onClick ->
            holder.itemView.setOnClickListener {
                onClick.onItemClick(position, surah)
            }
        }

    }

    override fun getItemCount(): Int = surasList.size

    var onItemClickListener: OnItemClickListener? = null

    fun interface OnItemClickListener {
        fun onItemClick(position: Int, surah: Surah)
    }

    class ViewHolder(val itemBinding: QuranSurahItemBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {

        fun bind(surah: Surah) {
            val surahNumber = surah.index.toString()
            itemBinding.surahNumberTv.text = surahNumber
            itemBinding.arSurahNameTv.text = surah.arabicName
            itemBinding.enSurahNameTv.text = surah.englishName
            val versesNumber = "${surah.versesNumber} Verses"
            itemBinding.versesNumberTv.text = versesNumber
        }
    }


}