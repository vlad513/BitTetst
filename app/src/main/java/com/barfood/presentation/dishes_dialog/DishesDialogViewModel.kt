package com.barfood.presentation.dishes_dialog

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.textfojin.domain.models.DishesDomain
import com.textfojin.domain.usecase.PostDatabaseUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DishesDialogViewModel(
    private val postDatabaseUseCase: PostDatabaseUseCase

) : ViewModel() {

    init {
        Log.e("AAA", "createVm")
    }


    fun addDishes(dishesDialogModel: DishesDomain) {
        viewModelScope.launch(Dispatchers.IO) {
            postDatabaseUseCase.execute(dishes = dishesDialogModel)
        }
    }
}