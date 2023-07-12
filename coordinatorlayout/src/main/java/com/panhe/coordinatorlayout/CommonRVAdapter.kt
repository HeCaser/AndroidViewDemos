package com.panhe.coordinatorlayout

import android.graphics.Color
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

/**
 * @author: hepan
 * @date: 2023/7/11
 * @desc:
 */
class CommonRVAdapter(private val itemCount: Int):RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    inner class RvCommonHolder(view: View) : RecyclerView.ViewHolder(view) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val ll = LinearLayout(parent.context)
        val view = TextView(parent.context).apply {
            textSize = 20f
            gravity = Gravity.CENTER

        }
        val line = View(parent.context)
        line.setBackgroundColor(Color.BLACK)


        ll.addView(view)
        ll.addView(line,LinearLayout.LayoutParams.MATCH_PARENT,2)
        return RvCommonHolder(ll)
    }

    override fun getItemCount(): Int {
        return itemCount
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
    }
}