package com.example.tvplayground

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.leanback.widget.*
import androidx.recyclerview.widget.RecyclerView

class MainAdapter : RecyclerView.Adapter<MainAdapter.ViewHolder>() {

    private val items = mutableListOf<ListItemModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.main_list_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    fun setItems(items: List<ListItemModel>) {
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val presenter = ListRowPresenter().apply {
            rowHeight = ViewGroup.LayoutParams.WRAP_CONTENT
            setNumRows(1)
        }
        private val itemAdapter = ArrayObjectAdapter(presenter)
        private val bridgeAdapter = ItemBridgeAdapter(itemAdapter)
        private val rowPresenter = RowPresenter(view.context)

        init {
            (view as VerticalGridView).adapter = bridgeAdapter
        }

        fun bind(listItemModel: ListItemModel) {
            val header = HeaderItem(listItemModel.title)
            val adapter = ArrayObjectAdapter(rowPresenter).apply { addAll(0, listItemModel.items) }
            val listRow = ListRow(header, adapter)

            itemAdapter.addAll(0, listOf(listRow))
        }
    }
}