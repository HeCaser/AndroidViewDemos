package com.panhe.coordinatorlayout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class AppBarLayoutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_app_bar_layout)

        val rv = findViewById<RecyclerView>(R.id.rv)
        rv.apply {
            adapter = CommonRVAdapter(100)
            layoutManager = LinearLayoutManager(this@AppBarLayoutActivity)
        }
    }
}