package com.example.hen.sichon.database

import android.arch.persistence.room.Room
import android.content.Context

object DataBaseInit
{
    lateinit var mDb: AppDatabase
    lateinit var mFavoriteDao: FavoriteDao

    fun initDb(context: Context)
    {
        mDb = Room.databaseBuilder(context,
                AppDatabase::class.java, "database-name").build()
        mFavoriteDao = mDb.favoriteDao()
    }

    fun isFavorite(phrase: String): Favorite
    {
        return mFavoriteDao.isFavorite(phrase)
    }

    fun insertFavorite()
    {
        val favorite = Favorite(phrase = "dog")
        mFavoriteDao.insertPhrase(favorite)
    }


}