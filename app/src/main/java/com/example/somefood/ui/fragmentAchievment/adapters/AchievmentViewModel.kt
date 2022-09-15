package com.example.somefood.ui.fragmentAchievment.adapters

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.somefood.data.model.OrderRating
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class AchievmentViewModel : ViewModel() {

    private val _list = MutableStateFlow<List<Achievment>?>(null)
    val list: Flow<List<Achievment>?> = _list

    init {
        getAllItemList()
    }
    fun main(): List<Achievment> {
        val jsonList =
            """[
                {
                    "typesDynamic": false,
                    "count": 0,
                    "countDays": 66,
                    "types": 0
                },
                {
                    "typesDynamic": false,
                    "count": 32,
                    "countDays": 76,
                    "types": 1
                },
                {
                    "typesDynamic": false,
                    "count": 28,
                    "countDays": 72,
                    "types": 2
                },
                {
                    "typesDynamic": true,
                    "count": 56,
                    "countDays": 81,
                    "types": 1
                },
                {
                    "typesDynamic": true,
                    "count": 33,
                    "countDays": 69,
                    "types": 0
                },
                {
                    "typesDynamic": false,
                    "count": 97,
                    "countDays": 13,
                    "types": 2
                },
                {
                    "typesDynamic": true,
                    "count": 67,
                    "countDays": 82,
                    "types": 0
                },
                {
                    "typesDynamic": false,
                    "count": 76,
                    "countDays": 42,
                    "types": 1
                },
                {
                    "typesDynamic": true,
                    "count": 50,
                    "countDays": 30,
                    "types": 2
                },
                {
                    "typesDynamic": false,
                    "count": 15,
                    "countDays": 10,
                    "types": 2
                }
            ]"""

        val gson = Gson()
        val arrayTutorialType = object : TypeToken<List<Achievment>>(){}.type

        val tutorials: List<Achievment> = gson.fromJson(jsonList, arrayTutorialType)
        tutorials.forEachIndexed  { idx, tut -> println("> Item ${idx}:\n${tut}") }
        return (tutorials)
    }

    private fun getAllItemList() {
        viewModelScope.launch {
            _list.value = main()
        }
    }

}