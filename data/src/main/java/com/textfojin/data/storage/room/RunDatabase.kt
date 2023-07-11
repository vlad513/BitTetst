package com.textfojin.data.storage.room


import androidx.room.*

import com.textfojin.data.storage.models.DishesModel

@Database(entities = [DishesModel::class], version = 1, exportSchema = false)
//@TypeConverters(TypeConverters::class)
abstract class RunDatabase: RoomDatabase() {
    abstract fun getRunDao(): Dao



}