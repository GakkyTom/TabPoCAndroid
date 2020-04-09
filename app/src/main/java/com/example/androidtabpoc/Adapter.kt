package com.example.androidtabpoc

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class Adapter(fragmentManager: FragmentManager, private val context: Context):
    FragmentPagerAdapter(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

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
        return when(position) {
            0 -> "ホーム"
            1 -> "かわいい"
            2 -> "あるある"
            3 -> "笑える"
            4 -> "なるほど"
            5 -> "泣ける"
            else -> "その他"
        }
    }
}