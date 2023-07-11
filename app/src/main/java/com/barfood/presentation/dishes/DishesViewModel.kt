package com.barfood.presentation.dishes

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.textfojin.domain.models.*

import com.textfojin.domain.usecase.GetDishesUseCase
import com.textfojin.domain.usecase.PostDatabaseUseCase
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DishesViewModel(
    private val getDishesUseCase: GetDishesUseCase,

    ) : ViewModel() {

    private var failureLiveData = MutableLiveData<Boolean>()
    val _failureLiveData: LiveData<Boolean> = failureLiveData

    private var dishesLiveData = MutableLiveData<ListDishesDomain>()
    val _dishesLiveData: LiveData<ListDishesDomain> = dishesLiveData

    init {
        Log.e("AAA", "createVm")

    }

    fun getDishes(sort: Int) {
        viewModelScope.launch(Dispatchers.IO+coroutineExceptionHandler) {
            val dishes: ListDishesDomain = getDishesUseCase.execute()
            sort(dishes, sort)
        }
    }

    fun sort(dishes: ListDishesDomain, sort: Int) {
        val listDishes = arrayListOf<DishesDomain>()
        dishes.dishes.forEach {
            when (sort) {
                0 -> {
                    dishes.dishes.forEach { dishes ->
                        dishes.tegs.forEach { tegs ->
                            if (tegs == "Все меню") {
                                listDishes.add(dishes)
                            }
                        }
                    }
                }
                1 -> {
                    dishes.dishes.forEach { dishes ->
                        dishes.tegs.forEach { tegs ->
                            if (tegs == "Салаты") {
                                listDishes.add(dishes)
                            }
                        }
                    }
                }
                2 -> {
                    dishes.dishes.forEach { dishes ->
                        dishes.tegs.forEach { tegs ->
                            if (tegs == "С рисом") {
                                listDishes.add(dishes)
                            }
                        }
                    }
                }
                3 -> {
                    dishes.dishes.forEach { dishes ->
                        dishes.tegs.forEach { tegs ->
                            if (tegs == "С рыбой") {
                                listDishes.add(dishes)
                            }
                        }
                    }
                }
            }
            val listDishesNoRepiate = listDishes.distinct()
            dishesLiveData.postValue(ListDishesDomain(listDishesNoRepiate))
        }
    }
    private val coroutineExceptionHandler = CoroutineExceptionHandler{ _, throwable ->
        failureLiveData.postValue(false)
    }
}