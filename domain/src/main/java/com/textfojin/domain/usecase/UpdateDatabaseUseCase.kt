package com.textfojin.domain.usecase

import com.textfojin.domain.models.DishesDialogModelDomain
import com.textfojin.domain.repository.BagRepository

class UpdateDatabaseUseCase (private val bagRepository: BagRepository) {
    suspend fun execute(dishes: DishesDialogModelDomain):Boolean {
        return bagRepository.updateDishes(dishes)
    }
}