package com.panhe.coordinatorlayout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class CoordinatorMainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.coordinator_activity_main)

//        val rv = findViewById<RecyclerView>(R.id.rv)
//        rv.apply {
//            adapter = CommonRVAdapter(100)
//            layoutManager = LinearLayoutManager(this@CoordinatorMainActivity)
//        }
    }
}