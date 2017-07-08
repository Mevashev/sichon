package com.example.hen.sichon.data

import android.arch.persistence.room.Room
import android.content.Context
import com.example.hen.sichon.data.daos.FavoriteDao
import com.example.hen.sichon.data.entities.FavoriteEntity

object Database
{
    lateinit var mFavoriteDb: FavoriteDatabase
    lateinit var mFavoriteDao: FavoriteDao

    fun init(context: Context)
    {
        mFavoriteDb = Room.databaseBuilder(context, FavoriteDatabase::class.java, "favorites").allowMainThreadQueries().build()
        mFavoriteDao = mFavoriteDb.favoriteDao()
    }

    fun isFavorite(categoryId: Int, phraseId: Int): Boolean
    {
        return mFavoriteDao.isFavorite(categoryId, phraseId)?.let { true } ?: false
    }

    fun getFavorites(): List<FavoriteEntity>
    {
        return mFavoriteDao.getFavorites()
    }

    fun insertFavorite(categoryId: Int, phraseId: Int)
    {
        val favorite = FavoriteEntity(phraseId = phraseId, categoryId = categoryId)
        mFavoriteDao.insertFavorite(favorite)
    }

    fun deleteFavorite(categoryId: Int, phraseId: Int)
    {
        val favorite = FavoriteEntity(phraseId = phraseId, categoryId = categoryId)
        mFavoriteDao.deleteFavorite(favorite)
    }
}