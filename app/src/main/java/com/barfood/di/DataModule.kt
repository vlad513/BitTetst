package com.barfood.di

import androidx.room.Room
import com.textfojin.data.networking.retrofit.RetrofitBuilder
import com.textfojin.data.networking.retrofit.RetrofitCreateRequest
import com.textfojin.data.repository.BagRepositoryImpl
import com.textfojin.data.repository.CategoriesRepositoryImpl
import com.textfojin.data.repository.DishesDialogRepositoryImpl
import com.textfojin.data.repository.DishesRepositoryImpl
import com.textfojin.data.storage.room.Dao
import com.textfojin.data.storage.room.RunDatabase
import com.textfojin.domain.repository.BagRepository
import com.textfojin.domain.repository.CategoriesRepository
import com.textfojin.domain.repository.DishesDialogRepository
import com.textfojin.domain.repository.DishesRepository
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module



val dataModule = module {
//
//    single<UserStorage> {
//        SharedPrefUserStorageImpl(context = get())
//    }
//
    single<CategoriesRepository> {
        CategoriesRepositoryImpl( retrofitCreateRequest = get())
    }
    single<RetrofitBuilder> {
        RetrofitBuilder()
    }
    single<RetrofitCreateRequest> {
        RetrofitCreateRequest(retrofitBuilder = get())
    }

    single<DishesRepository> {
        DishesRepositoryImpl(retrofitCreateRequest = get())
    }

    single<DishesDialogRepository> {
        DishesDialogRepositoryImpl(Dao = get())
    }
    single<BagRepository> {
        BagRepositoryImpl(dao = get())
    }

    // Room Database instance
    single <RunDatabase>{
        Room.databaseBuilder(
           androidApplication(), RunDatabase::class.java,"database").build()
    }
    single<Dao> {
        val database = get<RunDatabase>()
        database.getRunDao()
    }



}