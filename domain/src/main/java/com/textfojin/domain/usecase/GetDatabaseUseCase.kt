package com.textfojin.domain.usecase

import com.textfojin.domain.models.DishesDialogModelDomain
import com.textfojin.domain.repository.BagRepository


class GetDatabaseUseCase(private val bagRepository: BagRepository) {
    suspend fun execute(): List<DishesDialogModelDomain> {
        return bagRepository.getDishesBag()
    }
}