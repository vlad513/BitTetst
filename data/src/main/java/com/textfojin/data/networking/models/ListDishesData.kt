package com.textfojin.data.networking.models

data class ListDishesData(
    val dishes: List<DishesData>
)

data class DishesData(
    val id: Int?,
    val name: String?,
    val price: Int?,
    val weight: Int?,
    val description: String?,
    val image_url: String?,
    val tegs: List<String>
) : java.io.Serializable
