package com.panhe.coordinatorlayout

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class CoordinatorMainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.coordinator_activity_main)
    }

    fun goFund1(v: View) {
        startActivity(Intent(this, AppBarLayoutActivity::class.java))
    }

}