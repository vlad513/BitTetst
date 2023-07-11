package com.barfood.presentation.categories

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.textfojin.domain.models.ListCategoriesDomain
import com.textfojin.domain.usecase.GetCategoriesUseCase
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CategoriesViewModel(
    private val getCategoriesUseCase: GetCategoriesUseCase

) : ViewModel() {

    private var failureLiveData = MutableLiveData<Boolean>()
    val _failureLiveData: LiveData<Boolean> = failureLiveData

    private var categoriesLiveData = MutableLiveData<ListCategoriesDomain>()
    val _categoriesLiveData: LiveData<ListCategoriesDomain> = categoriesLiveData

    init {
        Log.e("AAA", "createVm")
    }


    fun getCategories() {
        viewModelScope.launch(Dispatchers.IO+coroutineExceptionHandler) {
            val userName: ListCategoriesDomain = getCategoriesUseCase.execute()
            categoriesLiveData.postValue(userName)
        }
    }
    private val coroutineExceptionHandler = CoroutineExceptionHandler{ _, throwable ->
        failureLiveData.postValue(false)

    }
}