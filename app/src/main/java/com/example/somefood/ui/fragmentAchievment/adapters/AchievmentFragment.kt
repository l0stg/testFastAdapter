package com.example.somefood.ui.fragmentAchievment.adapters

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.somefood.R
import com.example.somefood.databinding.FragmentAchievmentBinding
import com.example.somefood.ui.fragmentAchievment.adapters.adapters.AchievmentCategory
import com.example.somefood.ui.fragmentAchievment.adapters.adapters.AchivmentItem
import com.mikepenz.fastadapter.FastAdapter
import com.mikepenz.fastadapter.adapters.ItemAdapter
import com.mikepenz.fastadapter.items.AbstractItem
import org.koin.androidx.viewmodel.ext.android.viewModel

class AchievmentFragment : Fragment(R.layout.fragment_achievment) {


    private val binding: FragmentAchievmentBinding by viewBinding()
    private val viewModel: AchievmentViewModel by viewModel()
    private val itemsAdapter = ItemAdapter<AbstractItem<*>>()
    private val fastAdapter = FastAdapter.with(itemsAdapter)

    companion object {
        private const val SPAN_COUNT = 3
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding.weatherRecyclerView) {
            layoutManager = GridLayoutManager(requireContext(), SPAN_COUNT).apply {
                spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
                    override fun getSpanSize(position: Int): Int {
                        return when (fastAdapter.getItem(position)) {
                            is AchievmentCategory -> SPAN_COUNT
                            else -> 1
                        }
                    }
                }
            }
            adapter = fastAdapter
        }
        val list = listOf(
            AchievmentCategory("Недавние"),
            AchivmentItem(3),
            AchivmentItem(22),
            AchivmentItem(36),
            AchivmentItem(0),
            AchivmentItem(0),
            AchievmentCategory("Нет данных"),
            AchivmentItem(0),
            AchivmentItem(0),
        )
        itemsAdapter.setNewList(list)
    }
}