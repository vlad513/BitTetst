package com.textfojin.domain.usecase

import com.textfojin.domain.models.DishesDialogModelDomain
import com.textfojin.domain.models.DishesDomain
import com.textfojin.domain.repository.DishesDialogRepository

class PostDatabaseUseCase(private val dishesDialogRepository: DishesDialogRepository) {
    suspend fun execute(dishes:DishesDomain) {
        return dishesDialogRepository.addDishes(dishes = dishes)
    }
}