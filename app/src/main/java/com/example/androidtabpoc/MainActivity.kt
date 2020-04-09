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
            private val normal = StyleSpan(Typeface.BOLD)
            private val bold = ForegroundColorSpan(Color.WHITE)
            override fun onTabReselected(tab: TabLayout.Tab?) {
            }
            override fun onTabUnselected(tab: TabLayout.Tab?) {
                tab?.also {
                    it.text?.also { text ->
                        val span = if(text is SpannableString) text else SpannableString(text)
                        span.removeSpan(bold)
                        span.setSpan(
                                normal,
                                0,
                                text.length,
                                Spannable.SPAN_INCLUSIVE_INCLUSIVE
                        )
                        span.setSpan(
                                BackgroundColorSpan(Color.parseColor("#FFFBEA")),
                                0,
                                text.length,
                                Spannable.SPAN_INCLUSIVE_INCLUSIVE
                        )
                        it.text = span
                    }
                }
            }
            override fun onTabSelected(tab: TabLayout.Tab?) {
                tab?.also {
                    it.text?.also { text ->
                        val span = if(text is SpannableString) text else SpannableString(text)
                        span.removeSpan(normal)
                        span.setSpan(
                                bold,
                                0,
                                text.length,
                                Spannable.SPAN_INCLUSIVE_INCLUSIVE
                        )
                        span.setSpan(
                                BackgroundColorSpan(Color.parseColor(tabColors[it.position])),
                                0,
                                text.length,
                                Spannable.SPAN_INCLUSIVE_INCLUSIVE
                        )
                        it.text = span
                    }
                }
            }
        })

    }
}
