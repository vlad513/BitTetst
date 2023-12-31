package com.textfojin.data.networking

import com.textfojin.data.networking.models.ListCategoriesData
import com.textfojin.data.networking.models.ListDishesData
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("058729bd-1402-4578-88de-265481fd7d54")
    suspend fun getCategories(
    ): Response<ListCategoriesData>

    @GET("aba7ecaa-0a70-453b-b62d-0e326c859b3b")
    suspend fun getDishes(
    ):
    Response<ListDishesData>

}