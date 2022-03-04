package com.beit_and_pear.oldpeoplesinging

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.viewpager2.widget.ViewPager2

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // タイトルバーを非表示
        supportActionBar?.hide()

        // ページで利用するデータを準備
        val data = listOf(
            ListItem(
                title = "一月",
                photo = ContextCompat.getDrawable(this, R.drawable.takibi_1)
            ),
            ListItem(
                title = "二月",
                photo = ContextCompat.getDrawable(this, R.drawable.yuki_2)
            ),
        )

        // ViewPager2にデータをバインド
        val pager = findViewById<ViewPager2>(R.id.pager)
        pager.adapter = MyListAdapter(data)
    }
}