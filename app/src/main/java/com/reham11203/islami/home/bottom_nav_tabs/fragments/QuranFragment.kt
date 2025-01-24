package com.reham11203.islami.home.bottom_nav_tabs.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.reham11203.islami.AppConstants
import com.reham11203.islami.databinding.FragmentQuranBinding
import com.reham11203.islami.home.bottom_nav_tabs.adapters.SurasRecyclerAdapter
import com.reham11203.islami.home.bottom_nav_tabs.models.Surah
import com.reham11203.islami.home.suras_verses.SurahDetailsActivity

class QuranFragment : Fragment() {

    lateinit var binding: FragmentQuranBinding
    lateinit var adapter: SurasRecyclerAdapter
    val suras = listOf(
        Surah("الفاتحه", "Al-Fatiha", 7, 1),
        Surah("البقرة", "Al-Baqarah", 286, 2),
        Surah("آل عمران", "Aal-E-Imran", 200, 3),
        Surah("النساء", "An-Nisa", 176, 4),
        Surah("المائدة", "Al-Maidah", 120, 5),
        Surah("الأنعام", "Al-An'am", 165, 6),
        Surah("الأعراف", "Al-A'raf", 206, 7),
        Surah("الأنفال", "Al-Anfal", 75, 8),
        Surah("التوبة", "At-Tawbah", 129, 9),
        Surah("يونس", "Yunus", 109, 10),
        Surah("هود", "Hud", 123, 11),
        Surah("يوسف", "Yusuf", 111, 12),
        Surah("الرعد", "Ar-Ra'd", 43, 13),
        Surah("إبراهيم", "Ibrahim", 52, 14),
        Surah("الحجر", "Al-Hijr", 99, 15),
        Surah("النحل", "An-Nahl", 128, 16),
        Surah("الإسراء", "Al-Isra", 111, 17),
        Surah("الكهف", "Al-Kahf", 110, 18),
        Surah("مريم", "Maryam", 98, 19),
        Surah("طه", "Ta-Ha", 135, 20),
        Surah("الأنبياء", "Al-Anbiya", 112, 21),
        Surah("الحج", "Al-Hajj", 78, 22),
        Surah("المؤمنون", "Al-Mu'minun", 118, 23),
        Surah("النّور", "An-Nur", 64, 24),
        Surah("الفرقان", "Al-Furqan", 77, 25),
        Surah("الشعراء", "Ash-Shu'ara", 227, 26),
        Surah("النّمل", "An-Naml", 93, 27),
        Surah("القصص", "Al-Qasas", 88, 28),
        Surah("العنكبوت", "Al-Ankabut", 69, 29),
        Surah("الرّوم", "Ar-Rum", 60, 30),
        Surah("لقمان", "Luqman", 34, 31),
        Surah("السجدة", "As-Sajda", 30, 32),
        Surah("الأحزاب", "Al-Ahzab", 73, 33),
        Surah("سبأ", "Saba", 54, 34),
        Surah("فاطر", "Fatir", 45, 35),
        Surah("يس", "Ya-Sin", 83, 36),
        Surah("الصافات", "As-Saffat", 182, 37),
        Surah("ص", "Sad", 88, 38),
        Surah("الزمر", "Az-Zumar", 75, 39),
        Surah("غافر", "Ghafir", 85, 40),
        Surah("فصّلت", "Fussilat", 54, 41),
        Surah("الشورى", "Ash-Shura", 53, 42),
        Surah("الزخرف", "Az-Zukhruf", 89, 43),
        Surah("الدّخان", "Ad-Dukhan", 59, 44),
        Surah("الجاثية", "Al-Jathiya", 37, 45),
        Surah("الأحقاف", "Al-Ahqaf", 35, 46),
        Surah("محمد", "Muhammad", 38, 47),
        Surah("الفتح", "Al-Fath", 29, 48),
        Surah("الحجرات", "Al-Hujurat", 18, 49),
        Surah("ق", "Qaf", 45, 50),
        Surah("الذاريات", "Adh-Dhariyat", 60, 51),
        Surah("الطور", "At-Tur", 49, 52),
        Surah("النجم", "An-Najm", 62, 53),
        Surah("القمر", "Al-Qamar", 55, 54),
        Surah("الرحمن", "Ar-Rahman", 78, 55),
        Surah("الواقعة", "Al-Waqia", 96, 56),
        Surah("الحديد", "Al-Hadid", 29, 57),
        Surah("المجادلة", "Al-Mujadila", 22, 58),
        Surah("الحشر", "Al-Hashr", 24, 59),
        Surah("الممتحنة", "Al-Mumtahina", 13, 60),
        Surah("الصف", "As-Saff", 14, 61),
        Surah("الجمعة", "Al-Jumu'a", 11, 62),
        Surah("المنافقون", "Al-Munafiqoon", 11, 63),
        Surah("التغابن", "At-Taghabun", 18, 64),
        Surah("الطلاق", "At-Talaq", 12, 65),
        Surah("التحريم", "At-Tahrim", 12, 66),
        Surah("الملك", "Al-Mulk", 30, 67),
        Surah("القلم", "Al-Qalam", 52, 68),
        Surah("الحاقة", "Al-Haqqa", 52, 69),
        Surah("المعارج", "Al-Ma'arij", 44, 70),
        Surah("نوح", "Nuh", 28, 71),
        Surah("الجن", "Al-Jinn", 28, 72),
        Surah("المزّمّل", "Al-Muzzammil", 20, 73),
        Surah("المدّثر", "Al-Muddathir", 56, 74),
        Surah("القيامة", "Al-Qiyama", 40, 75),
        Surah("الإنسان", "Al-Insan", 31, 76),
        Surah("المرسلات", "Al-Mursalat", 50, 77),
        Surah("النبأ", "An-Naba", 40, 78),
        Surah("النازعات", "An-Nazi'at", 46, 79),
        Surah("عبس", "Abasa", 42, 80),
        Surah("التكوير", "At-Takwir", 29, 81),
        Surah("الإنفطار", "Al-Infitar", 19, 82),
        Surah("المطفّفين", "Al-Mutaffifin", 36, 83),
        Surah("الإنشقاق", "Al-Inshiqaq", 25, 84),
        Surah("البروج", "Al-Burooj", 22, 85),
        Surah("الطارق", "At-Tariq", 17, 86),
        Surah("الأعلى", "Al-A'la", 19, 87),
        Surah("الغاشية", "Al-Ghashiya", 26, 88),
        Surah("الفجر", "Al-Fajr", 30, 89),
        Surah("البلد", "Al-Balad", 20, 90),
        Surah("الشمس", "Ash-Shams", 15, 91),
        Surah("الليل", "Al-Lail", 21, 92),
        Surah("الضحى", "Ad-Duhaa", 11, 93),
        Surah("الشرح", "Ash-Sharh", 8, 94),
        Surah("التين", "At-Tin", 8, 95),
        Surah("العلق", "Al-Alaq", 19, 96),
        Surah("القدر", "Al-Qadr", 5, 97),
        Surah("البينة", "Al-Bayyina", 8, 98),
        Surah("الزلزلة", "Az-Zalzala", 8, 99),
        Surah("العاديات", "Al-Adiyat", 11, 100),
        Surah("القارعة", "Al-Qari'a", 11, 101),
        Surah("التكاثر", "At-Takathur", 8, 102),
        Surah("العصر", "Al-Asr", 3, 103),
        Surah("الهمزة", "Al-Humazah", 9, 104),
        Surah("الفيل", "Al-Fil", 5, 105),
        Surah("قريش", "Quraish", 4, 106),
        Surah("الماعون", "Al-Ma'un", 7, 107),
        Surah("الكوثر", "Al-Kawthar", 3, 108),
        Surah("الكافرون", "Al-Kafirun", 6, 109),
        Surah("النصر", "An-Nasr", 3, 110),
        Surah("المسد", "Al-Masad", 5, 111),
        Surah("الإخلاص", "Al-Ikhlas", 4, 112),
        Surah("الفلق", "Al-Falaq", 5, 113),
        Surah("الناس", "An-Nas", 6, 114)
    )


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentQuranBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = SurasRecyclerAdapter(suras)
        adapter.onItemClickListener = SurasRecyclerAdapter.OnItemClickListener { position, surah ->

            val intent = Intent(activity, SurahDetailsActivity::class.java)
            intent.putExtra(AppConstants.EXTRA_SURAH, surah)
            startActivity(intent)


        }
        binding.recyclerQuran.adapter = adapter
    }


}