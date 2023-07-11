package com.textfojin.domain.usecase

import com.textfojin.domain.models.ListDishesDomain
import com.textfojin.domain.repository.DishesRepository

class GetDishesUseCase(private val dishesRepository: DishesRepository) {
    suspend fun execute(): ListDishesDomain{
        return dishesRepository.getDishes()
    }
}