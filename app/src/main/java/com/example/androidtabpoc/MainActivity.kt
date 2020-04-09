package com.example.androidtabpoc

import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.BackgroundColorSpan
import android.text.style.ForegroundColorSpan
import android.text.style.StyleSpan
import android.util.Log
import android.view.animation.AnimationSet
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val tabItems = arrayOf("ホーム","かわいい","あるある","笑える","なるほど", "泣ける")
    private val tabColors = arrayOf("#FF889A","#FA963F","#F7BB36","#62BFBF","#8490D6","#72ACD8")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        pager.adapter = Adapter(supportFragmentManager, this)
        tabs.setupWithViewPager(pager)

        tabs.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabReselected(tab: TabLayout.Tab?) {
            }
            override fun onTabUnselected(tab: TabLayout.Tab?) {
                tab?.also {
                    it.text?.also { text ->
                        Log.v("unselected", it.position.toString())
                        val span = if(text is SpannableString) text else SpannableString(text)
                        span.setSpan(
                                ForegroundColorSpan(Color.parseColor(tabColors[it.position])),
                                0,
                                text.length,
                                Spannable.SPAN_INCLUSIVE_INCLUSIVE
                        )
                        it.text = span
                    }
                    tabs.setSelectedTabIndicatorColor(Color.parseColor(tabColors[it.position]))
                }
            }
            override fun onTabSelected(tab: TabLayout.Tab?) {
                tab?.also {
                    it.text?.also { text ->
                        Log.v("selected", it.position.toString())

                        val span = if(text is SpannableString) text else SpannableString(text)
                        span.setSpan(
                                ForegroundColorSpan(Color.WHITE),
                                0,
                                text.length,
                                Spannable.SPAN_INCLUSIVE_INCLUSIVE
                        )
                        it.text = span
                    }
                    tab_under_bar.setBackgroundColor(Color.parseColor(tabColors[it.position]))
                }
            }
        })

    }
}
