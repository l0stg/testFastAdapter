package com.example.somefood.ui.fragmentAchievment.adapters.adapters

import android.graphics.Color
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.example.somefood.R
import com.mikepenz.fastadapter.FastAdapter
import com.mikepenz.fastadapter.items.AbstractItem

open class AchivmentItem(
    var days: Int? = null
) : AbstractItem<AchivmentItem.ViewHolder>() {

    override val type: Int
        get() = R.id.rowLayout

    /** defines the layout which will be used for this item in the list */
    override val layoutRes: Int
        get() = R.layout.weather_item

    override fun getViewHolder(v: View): ViewHolder {
        return ViewHolder(v)
    }

    class ViewHolder(view: View) : FastAdapter.ViewHolder<AchivmentItem>(view) {
        var name1: TextView = view.findViewById(R.id.xDays)
        val ramka = view.findViewById<ImageView>(R.id.ramka)
        val fon = view.findViewById<ImageView>(R.id.fon)
        val dm = view.findViewById<TextView>(R.id.dayInMedal)
        override fun bindView(item: AchivmentItem, payloads: List<Any>) {
            name1.text = item.days.toString()
            dm.text = item.days.toString()
            when (item.days){
                in 7..21 -> {
                    fon.setColorFilter(Color.RED)
                }
                in 21..30 -> {
                    fon.setColorFilter(Color.YELLOW)
                }
                in 30..100 -> {
                    fon.setColorFilter(Color.GREEN)
                }
                else -> {
                    fon.setColorFilter(Color.WHITE)
                    ramka.setColorFilter(Color.GRAY)
                    dm.setTextColor(Color.GRAY)
                }
            }
        }

        override fun unbindView(item: AchivmentItem) {
            name1.text = null
        }
    }
}
