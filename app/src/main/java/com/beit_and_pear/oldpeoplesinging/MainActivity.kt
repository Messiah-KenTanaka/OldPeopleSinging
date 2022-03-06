package com.beit_and_pear.oldpeoplesinging

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
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

        // ログ
        Log.i("MyActivity", "OnCreate")

        // ページで利用するデータを準備
        val data = listOf(
            ListItem(
                icon = ContextCompat.getDrawable(this, R.drawable.icons8_1),
                photo = ContextCompat.getDrawable(this, R.drawable.takibi_1)
            ),
            ListItem(
                icon = ContextCompat.getDrawable(this, R.drawable.icons8_2),
                photo = ContextCompat.getDrawable(this, R.drawable.haruyokoi_2)
            ),
            ListItem(
                icon = ContextCompat.getDrawable(this, R.drawable.icons8_3),
                photo = ContextCompat.getDrawable(this, R.drawable.ureshihinamaturi_3)
            ),
            ListItem(
                icon = ContextCompat.getDrawable(this, R.drawable.icons8_4),
                photo = ContextCompat.getDrawable(this, R.drawable.harugakita_4)
            ),
            ListItem(
                icon = ContextCompat.getDrawable(this, R.drawable.icons8_5),
                photo = ContextCompat.getDrawable(this, R.drawable.kaasannouta_5)
            ),
            ListItem(
                icon = ContextCompat.getDrawable(this, R.drawable.icons8_6),
                photo = ContextCompat.getDrawable(this, R.drawable.katatumuri_6)
            ),
            ListItem(
                icon = ContextCompat.getDrawable(this, R.drawable.icons8_7),
                photo = ContextCompat.getDrawable(this, R.drawable.hamabenouta_7)
            ),
            ListItem(
                icon = ContextCompat.getDrawable(this, R.drawable.icons8_8),
                photo = ContextCompat.getDrawable(this, R.drawable.hakone_8)
            ),
            ListItem(
                icon = ContextCompat.getDrawable(this, R.drawable.icons8_9),
                photo = ContextCompat.getDrawable(this, R.drawable.akatonbo_9)
            ),
            ListItem(
                icon = ContextCompat.getDrawable(this, R.drawable.icons8_10),
                photo = ContextCompat.getDrawable(this, R.drawable.dennsyagoko_10)
            ),
            ListItem(
                icon = ContextCompat.getDrawable(this, R.drawable.icons8_11),
                photo = ContextCompat.getDrawable(this, R.drawable.makkanaaki_11)
            ),
            ListItem(
                icon = ContextCompat.getDrawable(this, R.drawable.icons8_12),
                photo = ContextCompat.getDrawable(this, R.drawable.fuyugesiki_12)
            ),
        )

        // ViewPager2にデータをバインド
        val tabs = findViewById<TabLayout>(R.id.tabs)
        val pager = findViewById<ViewPager2>(R.id.pager)
        pager.adapter = MyListAdapter(data)
        // TabLayout/ViewPagerの紐付け
        TabLayoutMediator(tabs, pager) { tab, position ->
            tab.apply {
                contentDescription = "Page ${position + 1}"
                icon = data[position].icon
            }
        }.attach()
    }
}