package com.beit_and_pear.oldpeoplesinging

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TableLayout
import androidx.core.content.ContextCompat
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // タイトルバーを非表示
        supportActionBar?.hide()

        // ページで利用するデータを準備
        val data = listOf(
            ListItem(
                shortTitle = "一月",
                icon = ContextCompat.getDrawable(this, R.drawable.icons8_1),
                photo = ContextCompat.getDrawable(this, R.drawable.oshougatsu_kashi_1)
            ),
            ListItem(
                shortTitle = "二月",
                icon = ContextCompat.getDrawable(this, R.drawable.icons8_2),
                photo = ContextCompat.getDrawable(this, R.drawable.onihasoto_2)
            ),
            ListItem(
                shortTitle = "三月",
                icon = ContextCompat.getDrawable(this, R.drawable.icons8_3),
                photo = ContextCompat.getDrawable(this, R.drawable.oshougatsu_kashi_1)
            ),
            ListItem(
                shortTitle = "四月",
                icon = ContextCompat.getDrawable(this, R.drawable.icons8_4),
                photo = ContextCompat.getDrawable(this, R.drawable.onihasoto_2)
            ),
            ListItem(
                shortTitle = "五月",
                icon = ContextCompat.getDrawable(this, R.drawable.icons8_5),
                photo = ContextCompat.getDrawable(this, R.drawable.oshougatsu_kashi_1)
            ),
            ListItem(
                shortTitle = "六月",
                icon = ContextCompat.getDrawable(this, R.drawable.icons8_6),
                photo = ContextCompat.getDrawable(this, R.drawable.onihasoto_2)
            ),
            ListItem(
                shortTitle = "七月",
                icon = ContextCompat.getDrawable(this, R.drawable.icons8_7),
                photo = ContextCompat.getDrawable(this, R.drawable.oshougatsu_kashi_1)
            ),
            ListItem(
                shortTitle = "八月",
                icon = ContextCompat.getDrawable(this, R.drawable.icons8_8),
                photo = ContextCompat.getDrawable(this, R.drawable.onihasoto_2)
            ),
            ListItem(
                shortTitle = "九月",
                icon = ContextCompat.getDrawable(this, R.drawable.icons8_9),
                photo = ContextCompat.getDrawable(this, R.drawable.oshougatsu_kashi_1)
            ),
            ListItem(
                shortTitle = "十月",
                icon = ContextCompat.getDrawable(this, R.drawable.icons8_10),
                photo = ContextCompat.getDrawable(this, R.drawable.onihasoto_2)
            ),
            ListItem(
                shortTitle = "十一月",
                icon = ContextCompat.getDrawable(this, R.drawable.icons8_11),
                photo = ContextCompat.getDrawable(this, R.drawable.oshougatsu_kashi_1)
            ),
            ListItem(
                shortTitle = "十二月",
                icon = ContextCompat.getDrawable(this, R.drawable.icons8_12),
                photo = ContextCompat.getDrawable(this, R.drawable.onihasoto_2)
            ),
        )

        // ViewPager2にデータをバインド
        val tabs = findViewById<TabLayout>(R.id.tabs)
        val pager = findViewById<ViewPager2>(R.id.pager)
        pager.adapter = MyListAdapter(data)
        // TabLayout/ViewPagerの紐付け
        TabLayoutMediator(tabs, pager) { tab, position ->
            tab.apply {
                text = data[position].shortTitle
                contentDescription = "Page ${position + 1}"
                icon = data[position].icon
            }
        }.attach()
    }
}