package com.textfojin.domain.usecase


import com.textfojin.domain.models.ListCategoriesDomain
import com.textfojin.domain.repository.CategoriesRepository

class GetCategoriesUseCase(private val categoriesRepository: CategoriesRepository) {
    suspend fun execute(): ListCategoriesDomain {
        return  categoriesRepository.getCategories()
    }
}