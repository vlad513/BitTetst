package com.textfojin.data.repository


import com.textfojin.data.networking.models.ListCategoriesData
import com.textfojin.data.networking.retrofit.RetrofitCreateRequest
import com.textfojin.domain.models.CategoriesDomain
import com.textfojin.domain.models.ListCategoriesDomain
import com.textfojin.domain.repository.CategoriesRepository


class CategoriesRepositoryImpl(private val retrofitCreateRequest: RetrofitCreateRequest) :
    CategoriesRepository {
    override suspend fun getCategories(): ListCategoriesDomain {
        val request = retrofitCreateRequest.create.getCategories()

        return mappers(listCategoriesData = request.body())

    }

    private fun mappers(listCategoriesData: ListCategoriesData?): ListCategoriesDomain {
        val listCategoriesDomain = arrayListOf<CategoriesDomain>()
        listCategoriesData!!.сategories.forEach {
            listCategoriesDomain.add(
                CategoriesDomain(
                    id = it?.id, name = it?.name, image_url = it?.image_url
                )
            )
        }
        return ListCategoriesDomain(listCategoriesDomain)
    }
}