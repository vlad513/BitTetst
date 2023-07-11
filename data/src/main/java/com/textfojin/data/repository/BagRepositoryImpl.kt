package com.textfojin.data.repository

import com.textfojin.data.storage.models.DishesModel
import com.textfojin.data.storage.room.Dao
import com.textfojin.domain.models.DishesDialogModelDomain
import com.textfojin.domain.repository.BagRepository

class BagRepositoryImpl(private val dao: Dao) : BagRepository {
    override suspend fun getDishesBag(): List<DishesDialogModelDomain> {
        return mappersDom(dao.readAllDishes())
    }

    override suspend fun deleteDishes(dishes: DishesDialogModelDomain): Boolean {
        dao.deleteDishes(mappersDat(dishes))
        return true
    }

    override suspend fun updateDishes(dishes: DishesDialogModelDomain): Boolean {
        dao.updateDishes(mappersDat(dishes))
        return true
    }


    private fun mappersDat(dishes: DishesDialogModelDomain): DishesModel {
        return DishesModel(
            id = dishes.id,
            name = dishes.name,
            price = dishes.price,
            weight = dishes.weight,
            description = dishes.description,
            image_url = dishes.image_url,
            count = dishes.count
        )
    }

    private fun mappersDom(dishes: List<DishesModel>): List<DishesDialogModelDomain> {
        val listDishes = arrayListOf<DishesDialogModelDomain>()
        dishes.forEach {
            listDishes.add(
                DishesDialogModelDomain(
                    id = it.id,
                    name = it.name,
                    price = it.price,
                    weight = it.weight,
                    description = it.description,
                    image_url = it.image_url,
                    count = it.count
                )
            )
        }
        return listDishes
    }
}