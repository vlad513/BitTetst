package com.barfood.di

import com.textfojin.domain.usecase.*
import org.koin.dsl.module


val domainModule = module {

    factory<GetCategoriesUseCase> {
        GetCategoriesUseCase(
            categoriesRepository = get()
        )
    }

    factory<GetDishesUseCase> {
        GetDishesUseCase(
            dishesRepository = get()
        )
    }

    factory<UpdateDatabaseUseCase> {
        UpdateDatabaseUseCase(
            bagRepository = get()
        )
    }
    factory<DeleteDatabaseUseCase> {
        DeleteDatabaseUseCase(
            bagRepository = get()
        )
    }

    factory<PostDatabaseUseCase> {
        PostDatabaseUseCase(
            dishesDialogRepository = get()
        )
    }

    factory<GetDatabaseUseCase> {
        GetDatabaseUseCase(
            bagRepository = get()
        )
    }

}

