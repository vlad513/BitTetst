package com.textfojin.domain.repository

import com.textfojin.domain.models.DishesDialogModelDomain
import com.textfojin.domain.models.DishesDomain

interface DishesDialogRepository {
    suspend fun addDishes(dishes: DishesDomain){
    }
}