package com.example.hen.sichon.database

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query

@Dao
interface FavoriteDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPhrase(favorite: Favorite)


    @Query("SELECT * FROM favorite WHERE favorite_phrase LIKE :phrase")
    fun isFavorite(phrase: String): Favorite
}