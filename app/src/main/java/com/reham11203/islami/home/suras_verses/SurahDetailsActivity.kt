package com.reham11203.islami.home.suras_verses

import android.os.Build
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.reham11203.islami.AppConstants
import com.reham11203.islami.databinding.ActivitySurahDetailsBinding
import com.reham11203.islami.home.bottom_nav_tabs.models.Surah

@Suppress("DEPRECATION")
class SurahDetailsActivity : AppCompatActivity() {

    lateinit var binding: ActivitySurahDetailsBinding
    lateinit var adapter: VersesRecyclerAdapter
    var surah: Surah? = null
    lateinit var versesList: MutableList<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivitySurahDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        init()
        initRecyclerView()

    }

    private fun initRecyclerView() {
        adapter = VersesRecyclerAdapter(versesList)
        binding.content.versesRecyclerView.adapter = adapter
    }

    fun init() {

        setSupportActionBar(binding.toolBar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.title = null

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            surah = intent.getParcelableExtra(
                AppConstants.EXTRA_SURAH,
                Surah::class.java
            )
        } else {
            surah = intent.getParcelableExtra(
                AppConstants.EXTRA_SURAH
            )
        }
        readSurahDetails(surah!!.index)
        binding.surahTitle.text = surah?.englishName
        binding.content.surahTitleAr.text = surah?.arabicName
    }


    fun readSurahDetails(surahIndex: Int) {
        val content = assets.open("quran/${surahIndex}.txt").bufferedReader().use { it.readText() }

        versesList = content.trim().split("\n").toMutableList()

        for (i in 0..<versesList.size) {
            versesList[i] += "[${i + 1}]"
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressedDispatcher.onBackPressed()
        return true
    }
}