package com.example.androidtabpoc

import android.content.Context
import android.graphics.Color
import android.text.Spannable
import android.text.SpannableString
import android.text.SpannableStringBuilder
import android.text.Spanned
import android.text.style.AbsoluteSizeSpan
import android.text.style.BackgroundColorSpan
import android.text.style.ForegroundColorSpan
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class Adapter(fragmentManager: FragmentManager, private val context: Context):
    FragmentPagerAdapter(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    private val tabItems = arrayOf("トップ","かわいい","あるある","笑える","なるほど", "泣ける")
    private val tabColors = arrayOf("#FF889A","#FA963F","#F7BB36","#62BFBF","#8490D6","#72ACD8")

    override fun getItem(position: Int): Fragment {
        return when(position) {
            0 -> HomeTabFragment()
            else -> OtherTabFragment()
        }
    }

    override fun getCount(): Int {
        return 6
    }

    override fun getPageTitle(position: Int): CharSequence? {
        val spannable = SpannableStringBuilder(tabItems[position])
        // タブ文字色の初期設定
        spannable.setSpan(
                ForegroundColorSpan(Color.parseColor(tabColors[position])),
                0, // start
                tabItems[position].length, // end
                Spannable.SPAN_EXCLUSIVE_INCLUSIVE
        )

        return spannable
    }
}