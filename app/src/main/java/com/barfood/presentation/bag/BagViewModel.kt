package com.barfood.presentation.bag

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.textfojin.domain.models.DishesDialogModelDomain
import com.textfojin.domain.usecase.DeleteDatabaseUseCase
import com.textfojin.domain.usecase.GetDatabaseUseCase
import com.textfojin.domain.usecase.UpdateDatabaseUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class BagViewModel(
    private val getDatabaseUseCase: GetDatabaseUseCase,
    private val updateDatabaseUseCase: UpdateDatabaseUseCase,
    private val deleteDatabaseUseCase: DeleteDatabaseUseCase
) : ViewModel() {
    private var dishesLiveData = MutableLiveData<List<DishesDialogModelDomain>>()
    val _dishesLiveData: LiveData<List<DishesDialogModelDomain>> = dishesLiveData

    private var updateLiveData = MutableLiveData<Boolean>()
    val _updateLiveData: LiveData<Boolean> = updateLiveData

    private var deleteLiveData = MutableLiveData<Boolean>()
    val _deleteLiveData: LiveData<Boolean> = deleteLiveData

    init {
        Log.e("AAA", "createVm")


    }

    fun getDishes() {
        viewModelScope.launch(Dispatchers.IO) {
            dishesLiveData.postValue(getDatabaseUseCase.execute())
        }
    }

    fun deleteDishes(dishesDialogModelDomain: DishesDialogModelDomain) {
        viewModelScope.launch(Dispatchers.IO) {
            if (dishesDialogModelDomain.count?.equals(0) == true) {
                viewModelScope.launch(Dispatchers.IO) {
                    deleteLiveData.postValue(deleteDatabaseUseCase.execute(dishes = dishesDialogModelDomain))
                }
            } else {
                viewModelScope.launch(Dispatchers.IO) {
                    updateLiveData.postValue(updateDatabaseUseCase.execute(dishes = dishesDialogModelDomain))

                }
            }
        }
    }

    fun updateDishes(dishesDialogModelDomain: DishesDialogModelDomain) {
        viewModelScope.launch(Dispatchers.IO) {
            updateLiveData.postValue(updateDatabaseUseCase.execute(dishes = dishesDialogModelDomain))
        }
    }

}
