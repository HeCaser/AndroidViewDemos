package com.panhe.coordinatorlayout.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.appbar.AppBarLayout
import com.panhe.coordinatorlayout.adapter.CommonRVAdapter
import com.panhe.coordinatorlayout.R

class AppBarLayoutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_app_bar_layout)

        val rv = findViewById<RecyclerView>(R.id.rv)
        rv.apply {
            adapter = CommonRVAdapter(100)
            layoutManager = LinearLayoutManager(this@AppBarLayoutActivity)
        }


        initAppBar()
    }


    private fun initAppBar(){
        val appBar = findViewById<AppBarLayout>(R.id.appBar)
        // 监听 AppBar 移动的偏移量
        appBar.addOnOffsetChangedListener { appBarLayout, verticalOffset ->
            println("hepan total height = ${appBarLayout.height}  offset = $verticalOffset" )
        }

    }
}