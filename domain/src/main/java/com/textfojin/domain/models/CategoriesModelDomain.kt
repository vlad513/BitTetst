package com.textfojin.domain.models

data class CategoriesDomain(
    val id: Int?,
    val name: String?,
    val image_url: String?
)
 data class ListCategoriesDomain(
    val categories: List<CategoriesDomain?>
)