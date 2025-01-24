package com.reham11203.islami

import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.reham11203.islami.databinding.ActivitySurahDetailsBinding
import com.reham11203.islami.home.bottom_nav_tabs.models.Surah

class SurahDetailsActivity : AppCompatActivity() {

    lateinit var binding: ActivitySurahDetailsBinding
    var surah: Surah? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySurahDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        init()

    }

    fun init() {
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
    }

    fun readSurahDetails(surahIndex: Int) {
        val content = assets.open("quran/${surahIndex}.txt").bufferedReader().use { it.readText() }

        val verses = content.split("\n")


    }
}