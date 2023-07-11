package com.textfojin.data.storage.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "dishes_table")
data class DishesModel(
    @PrimaryKey
    val id: Int?,
    val name: String?,
    val price: Int?,
    val weight: Int?,
    val description: String?,
    val image_url: String?,
    val count: Int?
)