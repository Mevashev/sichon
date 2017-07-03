package com.example.hen.sichon.database

import android.arch.lifecycle.LiveData
import android.content.Context
import android.arch.persistence.room.Room

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

    fun isFavorite(phrase: String): LiveData<Favorite>
    {
        return mFavoriteDao.isFavorite(phrase)
    }

}