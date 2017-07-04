package com.example.hen.sichon.database

import android.arch.persistence.room.*

@Dao
interface FavoriteDao {
    @Insert
    fun insertFavorite(favorite: Favorite)

    @Delete
    fun deleteFavorite(favorite: Favorite)

    @Query("SELECT * FROM favorite WHERE category_id LIKE :arg0 AND phrase_index LIKE :arg1")
    fun isFavorite(categoryId: Int, phraseIndex: Int): Favorite?
}