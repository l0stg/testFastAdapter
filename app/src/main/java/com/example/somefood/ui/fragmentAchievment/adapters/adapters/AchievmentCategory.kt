package com.example.somefood.ui.fragmentAchievment.adapters.adapters

import android.view.View
import android.widget.TextView
import com.example.somefood.R
import com.mikepenz.fastadapter.FastAdapter
import com.mikepenz.fastadapter.items.AbstractItem

class AchievmentCategory(
    var name: String? = null
) : AbstractItem<AchievmentCategory.ViewHolder>() {

    override val type: Int
        get() = R.id.item_category

    /** defines the layout which will be used for this item in the list */
    override val layoutRes: Int
        get() = R.layout.weather_item_category

    override fun getViewHolder(v: View): ViewHolder {
        return ViewHolder(v)
    }

    class ViewHolder(view: View) : FastAdapter.ViewHolder<AchievmentCategory>(view) {
        var name1: TextView = view.findViewById(R.id.textView2)
        override fun bindView(item: AchievmentCategory, payloads: List<Any>) {
            name1.text = item.name
        }

        override fun unbindView(item: AchievmentCategory) {
            name1.text = null
        }
    }
}
