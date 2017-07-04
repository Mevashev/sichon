package com.example.hen.sichon.database

import android.arch.persistence.room.Room
import android.content.Context

object DataBaseInit
{
    lateinit var mDb: AppDatabase
    lateinit var mFavoriteDao: FavoriteDao

    fun initDb(context: Context)
    {
        mDb = Room.databaseBuilder(context, AppDatabase::class.java, "database-name").allowMainThreadQueries().build()
        mFavoriteDao = mDb.favoriteDao()
    }

    fun isFavorite(categoryId: Int, phraseIndex: Int): Boolean
    {
        return mFavoriteDao.isFavorite(categoryId, phraseIndex)?.let { true } ?: false
    }

    fun insertFavorite(categoryId: Int, phraseIndex: Int)
    {
        val favorite = Favorite(categoryId = categoryId, phraseIndex = phraseIndex)
        mFavoriteDao.insertFavorite(favorite)
    }

    fun deleteFavorite(categoryId: Int, phraseIndex: Int)
    {
        val favorite = Favorite(categoryId = categoryId, phraseIndex = phraseIndex)
        mFavoriteDao.deleteFavorite(favorite)
    }
}