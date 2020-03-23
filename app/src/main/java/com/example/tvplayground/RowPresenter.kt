package com.example.tvplayground

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.leanback.widget.Presenter

class RowPresenter(private val context: Context) : Presenter() {
    override fun onCreateViewHolder(parent: ViewGroup): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.vertical_grid_view_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, item: Any) {
        val text = item as String
        (viewHolder.view as TextView).text = text
    }

    override fun onUnbindViewHolder(viewHolder: ViewHolder?) {
        // no-op
    }
}
