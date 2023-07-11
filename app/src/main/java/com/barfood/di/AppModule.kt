package com.barfood.di

import com.barfood.presentation.bag.BagViewModel
import com.barfood.presentation.categories.CategoriesViewModel
import com.barfood.presentation.dishes.DishesViewModel
import com.barfood.presentation.dishes_dialog.DishesDialogViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel<CategoriesViewModel> {
        CategoriesViewModel(
           getCategoriesUseCase = get()
        )
    }
    viewModel<DishesViewModel> {
        DishesViewModel(
            getDishesUseCase = get(),

        )
    }
    viewModel<DishesDialogViewModel> {
        DishesDialogViewModel(
            postDatabaseUseCase = get()
        )
    }

    viewModel<BagViewModel> {
        BagViewModel(
            getDatabaseUseCase = get(),
            updateDatabaseUseCase = get(),
            deleteDatabaseUseCase = get(),
        )
    }
}