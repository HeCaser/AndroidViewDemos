package com.panhe.recyclerview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.xqtest.scrollabletable.demo.ScrollTableTestActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }


    fun goFund1(v: View) {
        startActivity(Intent(this, ScrollTableTestActivity::class.java))
    }

}