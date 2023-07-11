package com.textfojin.data.networking.models


data class ListCategoriesData(
    val сategories: List<CategoriesData?>
)
data class CategoriesData(
    val id: Int?,
    val name: String?,
    val image_url: String?
)
