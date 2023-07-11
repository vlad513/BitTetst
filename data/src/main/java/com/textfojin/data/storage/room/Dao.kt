package com.textfojin.data.storage.room

import androidx.lifecycle.LiveData
import androidx.room.*
import androidx.room.Dao
import com.textfojin.data.storage.models.DishesModel
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

@Dao
interface Dao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addDishes(user: DishesModel)

    @Query("SELECT * FROM dishes_table")
    suspend fun readAllDishes(): List<DishesModel>

    @Update
    suspend fun updateDishes(user:DishesModel)

    @Delete
    suspend fun deleteDishes(user:DishesModel)
}