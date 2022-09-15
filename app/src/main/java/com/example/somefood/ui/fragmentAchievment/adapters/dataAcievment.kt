package com.example.somefood.ui.fragmentAchievment.adapters


enum class StandartAchievmentTypes {
    YELLOW,
    GREEN,
    PINK,
}

data class Achievment(
    val typesDynamic: Boolean,
    val count: Int, // число из формулы подсчета
    val countDays: Int, // Сколько дней выполняется
    val types: Int
)

