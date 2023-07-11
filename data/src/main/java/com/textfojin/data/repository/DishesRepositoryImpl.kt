package com.textfojin.data.repository

import com.textfojin.data.networking.models.ListDishesData
import com.textfojin.data.networking.retrofit.RetrofitCreateRequest
import com.textfojin.domain.models.DishesDomain
import com.textfojin.domain.models.ListDishesDomain
import com.textfojin.domain.repository.DishesRepository

class DishesRepositoryImpl(private val retrofitCreateRequest: RetrofitCreateRequest) :
    DishesRepository {
    override suspend fun getDishes(): ListDishesDomain {
        val request = retrofitCreateRequest.create.getDishes()

        return mappers(listDishesData = request.body()!!)
    }


    private fun mappers(listDishesData: ListDishesData): ListDishesDomain {
        val listDomain = arrayListOf<DishesDomain>()
        listDishesData.dishes.forEach {
            listDomain.add(
                DishesDomain(
                    id = it.id,
                    name = it.name,
                    price = it.price,
                    weight = it.weight,
                    description = it.description,
                    image_url = it.image_url,
                    tegs = it.tegs
                )
            )
        }
        return ListDishesDomain(listDomain)
    }
}