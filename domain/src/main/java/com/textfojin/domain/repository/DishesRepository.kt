package com.textfojin.domain.repository

import com.textfojin.domain.models.ListDishesDomain


interface DishesRepository {
    suspend fun getDishes ():ListDishesDomain
}