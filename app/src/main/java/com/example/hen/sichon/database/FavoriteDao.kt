package com.example.hen.sichon.database

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Query

interface FavoriteDao
{
    @Query("SELECT * FROM favorite WHERE favorite_phrase LIKE :phrase")
    fun isFavorite(phrase: String): LiveData<Favorite>
}