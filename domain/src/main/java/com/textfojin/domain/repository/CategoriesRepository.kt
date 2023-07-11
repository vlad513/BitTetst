package com.textfojin.domain.repository

import com.textfojin.domain.models.ListCategoriesDomain


interface CategoriesRepository {
    suspend fun getCategories ():ListCategoriesDomain
}