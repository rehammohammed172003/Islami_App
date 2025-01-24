package com.reham11203.islami.home

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.reham11203.islami.R
import com.reham11203.islami.databinding.ActivityHomeBinding
import com.reham11203.islami.home.bottom_nav_tabs.fragments.HadithFragment
import com.reham11203.islami.home.bottom_nav_tabs.fragments.QuranFragment
import com.reham11203.islami.home.bottom_nav_tabs.fragments.RadioFragment
import com.reham11203.islami.home.bottom_nav_tabs.fragments.TasbehFragment


class HomeActivity : AppCompatActivity() {
    lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        showFragment(QuranFragment())
        binding.bottomNavView.setOnItemSelectedListener { menuItem ->

            var fragment: Fragment = when (menuItem.itemId) {
                R.id.quran -> {
                    QuranFragment()

                }

                R.id.hadith -> {
                    HadithFragment()

                }

                R.id.sepha -> {
                    TasbehFragment()

                }

                R.id.radio -> {
                    RadioFragment()

                }

                else -> {
                    QuranFragment()
                }
            }
            showFragment(fragment)

            return@setOnItemSelectedListener true
        }
    }

    private fun showFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }
}