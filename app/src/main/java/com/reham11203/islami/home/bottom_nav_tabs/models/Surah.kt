package com.reham11203.islami.home.bottom_nav_tabs.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Surah(
    val arabicName: String,
    val englishName: String,
    val versesNumber: Int,
    val index: Int
) : Parcelable

