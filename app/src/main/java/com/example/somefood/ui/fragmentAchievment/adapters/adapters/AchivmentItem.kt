package com.example.somefood.ui.fragmentAchievment.adapters.adapters

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.example.somefood.R
import com.example.somefood.ui.fragmentAchievment.adapters.Achievment
import com.mikepenz.fastadapter.FastAdapter
import com.mikepenz.fastadapter.items.AbstractItem

open class AchivmentItem(
    val data: Achievment
) : AbstractItem<AchivmentItem.ViewHolder>() {

    override val type: Int
        get() = R.id.rowLayout

    override val layoutRes: Int
        get() = R.layout.weather_item

    override fun getViewHolder(v: View): ViewHolder {
        return ViewHolder(v)
    }

    class ViewHolder(private val view: View) : FastAdapter.ViewHolder<AchivmentItem>(view) {
        var countDyasView: TextView = view.findViewById(R.id.xDays)
        private val medal: ImageView = view.findViewById(R.id.fon)
        val dayInMedalTextView = view.findViewById<TextView>(R.id.dayInMedal)
        override fun bindView(item: AchivmentItem, payloads: List<Any>) {
            countDyasView.text = item.data.countDays.toString()
            if(item.data.typesDynamic){
                dayInMedalTextView.text = item.data.countDays.toString()
                when (item.data.count){
                    in 0..20 -> {
                        medal.setImageResource(R.drawable.ic_pink_medal)
                    }
                    in 21..50 -> {
                        medal.setImageResource(R.drawable.ic_yellow_medal)
                    }
                    in 50..Int.MAX_VALUE -> {
                        medal.setImageResource(R.drawable.ic_greenmedal)
                    }
                    else -> {
                        medal.setImageResource(R.drawable.ic_nukk_medal)
                    }
                }
            } else {
                dayInMedalTextView.text = item.data.countDays.toString()
                when (item.data.types){
                    0 -> medal.setImageResource(R.drawable.ic_pink_medal)
                    1 -> medal.setImageResource(R.drawable.ic_yellow_medal)
                    2 -> medal.setImageResource(R.drawable.ic_greenmedal)

                }
            }
        }

        override fun unbindView(item: AchivmentItem) {
        }
    }
}
