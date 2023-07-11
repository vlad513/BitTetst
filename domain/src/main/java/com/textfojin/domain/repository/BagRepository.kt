package com.textfojin.domain.repository

import com.textfojin.domain.models.DishesDialogModelDomain

interface BagRepository {
    suspend fun getDishesBag ():List<DishesDialogModelDomain>
    suspend fun deleteDishes (dishes: DishesDialogModelDomain):Boolean
    suspend fun updateDishes (dishes: DishesDialogModelDomain):Boolean
}