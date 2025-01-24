package com.reham11203.islami.home.suras_verses

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.reham11203.islami.databinding.ItemVerseBinding

class VersesRecyclerAdapter(val verses: List<String>) :
    RecyclerView.Adapter<VersesRecyclerAdapter.ViewHolder>() {

    class ViewHolder(val itemBinding: ItemVerseBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemVerseBinding.inflate(
            LayoutInflater.from(parent.context),
            parent, false
        )

        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = verses.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemBinding.verseContent.text = verses[position]
    }
}