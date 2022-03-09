package com.beit_and_pear.oldpeoplesinging

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TableLayout
import androidx.core.content.ContextCompat
import androidx.viewpager2.widget.ViewPager2
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdSize
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    lateinit var mAdView : AdView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // タイトルバーを非表示
        supportActionBar?.hide()

        // 広告
        MobileAds.initialize(this) {}

        mAdView = findViewById(R.id.adView)
        val adRequest = AdRequest.Builder().build()
        mAdView.loadAd(adRequest)

        val adView = AdView(this)

        adView.adSize = AdSize.SMART_BANNER
//      ユニットID本物  ca-app-pub-3324255919208405/6762337987
        adView.adUnitId = "ca-app-pub-3324255919208405/6762337987"

//        // ログ
//        Log.i("MyActivity", "OnCreate")

        // ページで利用するデータを準備
        val data = listOf(
            ListItem(
                icon = ContextCompat.getDrawable(this, R.drawable.icons8_1),
                photo = ContextCompat.getDrawable(this, R.drawable.osyougatu_1)
            ),
            ListItem(
                icon = ContextCompat.getDrawable(this, R.drawable.icons8_2),
                photo = ContextCompat.getDrawable(this, R.drawable.oninopantu_2)
            ),
            ListItem(
                icon = ContextCompat.getDrawable(this, R.drawable.icons8_3),
                photo = ContextCompat.getDrawable(this, R.drawable.ureshihinamaturi_3)
            ),
            ListItem(
                icon = ContextCompat.getDrawable(this, R.drawable.icons8_4),
                photo = ContextCompat.getDrawable(this, R.drawable.harunoogawa_4)
            ),
            ListItem(
                icon = ContextCompat.getDrawable(this, R.drawable.icons8_5),
                photo = ContextCompat.getDrawable(this, R.drawable.koinobori_5)
            ),
            ListItem(
                icon = ContextCompat.getDrawable(this, R.drawable.icons8_6),
                photo = ContextCompat.getDrawable(this, R.drawable.katatumuri_6)
            ),
            ListItem(
                icon = ContextCompat.getDrawable(this, R.drawable.icons8_7),
                photo = ContextCompat.getDrawable(this, R.drawable.tanabatasama_7)
            ),
            ListItem(
                icon = ContextCompat.getDrawable(this, R.drawable.icons8_8),
                photo = ContextCompat.getDrawable(this, R.drawable.natunoomoide_8)
            ),
            ListItem(
                icon = ContextCompat.getDrawable(this, R.drawable.icons8_9),
                photo = ContextCompat.getDrawable(this, R.drawable.usagiusagi_9)
            ),
            ListItem(
                icon = ContextCompat.getDrawable(this, R.drawable.icons8_10),
                photo = ContextCompat.getDrawable(this, R.drawable.momizi_10)
            ),
            ListItem(
                icon = ContextCompat.getDrawable(this, R.drawable.icons8_11),
                photo = ContextCompat.getDrawable(this, R.drawable.akatonnbo_11)
            ),
            ListItem(
                icon = ContextCompat.getDrawable(this, R.drawable.icons8_12),
                photo = ContextCompat.getDrawable(this, R.drawable.akahananotonakai_12)
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