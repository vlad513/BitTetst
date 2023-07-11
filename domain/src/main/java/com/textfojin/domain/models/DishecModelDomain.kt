package com.textfojin.domain.models

data class ListDishesDomain(
    val dishes: List<DishesDomain>
) : java.io.Serializable

data class DishesDomain(
    val id: Int?,
    val name: String?,
    val price: Int?,
    val weight: Int?,
    val description: String?,
    val image_url: String?,
    val tegs: List<String>
) : java.io.Serializable

