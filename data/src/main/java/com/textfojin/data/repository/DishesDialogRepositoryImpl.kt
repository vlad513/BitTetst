package com.textfojin.data.repository

import com.textfojin.data.storage.models.DishesModel
import com.textfojin.data.storage.room.Dao
import com.textfojin.domain.models.DishesDialogModelDomain
import com.textfojin.domain.models.DishesDomain
import com.textfojin.domain.repository.DishesDialogRepository

class DishesDialogRepositoryImpl(private val Dao: Dao) : DishesDialogRepository {
    override suspend fun addDishes(dishes: DishesDomain) {
        Dao.addDishes(
            user = DishesModel(
                id = dishes.id,
                name = dishes.name,
                price = dishes.price,
                weight = dishes.weight,
                description = dishes.description,
                image_url = dishes.image_url,
                count = 1
            )
        )
    }
}