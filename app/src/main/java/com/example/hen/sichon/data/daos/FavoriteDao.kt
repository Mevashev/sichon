package com.example.hen.sichon.data.daos

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Delete
import android.arch.persistence.room.Insert
import com.example.hen.sichon.data.entities.FavoriteEntity
import com.example.hen.sichon.data.entities.PhraseEntity

@Dao
interface FavoriteDao
{
    @Insert
    fun insertFavorite(phrase: FavoriteEntity)

    @Delete
    fun deleteFavorite(phrase: FavoriteEntity)

//    @Query("SELECT * FROM favorites WHERE category_id LIKE :arg0 AND phrase_index LIKE :arg1")
//    fun isFavorite(categoryId: Int, phraseIndex: Int): PhraseEntity?
}