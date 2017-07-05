package com.example.hen.sichon.data

import android.arch.persistence.room.Room
import android.content.Context
import com.example.hen.sichon.data.daos.FavoriteDao
import com.example.hen.sichon.data.daos.PhraseDao
import com.example.hen.sichon.data.entities.PhraseEntity
import com.example.hen.sichon.data.models.Data

object Database
{
    lateinit var mFavoriteDb: FavoriteDatabase
    lateinit var mPhraseDb: PhraseDatabase
    lateinit var mPhraseDao: PhraseDao
    lateinit var mFavoriteDao: FavoriteDao

    fun init(context: Context)
    {
        mPhraseDb = Room.databaseBuilder(context, PhraseDatabase::class.java, "phrases").allowMainThreadQueries().build()
        mFavoriteDb = Room.databaseBuilder(context, FavoriteDatabase::class.java, "favorites").allowMainThreadQueries().build()
        mPhraseDao = mPhraseDb.phraseDao()
        mFavoriteDao = mFavoriteDb.favoriteDao()
    }

    fun insertAllPhrases(data: Data)
    {
        for (category in data.categories)
        {
            for (phrase in category.phrases)
            {
                val phraseEntity = PhraseEntity(phrase.id, category.id, phrase.english, phrase.hebrew, phrase.russian)
                mPhraseDao.insertPhrase(phraseEntity)
            }
        }
    }

//    fun isFavorite(categoryId: Int, phraseIndex: Int): Boolean
//    {
//        return mFavoriteDao.isFavorite(categoryId, phraseIndex)?.let { true } ?: false
//    }
//
//    fun insertFavorite(categoryId: Int, phraseIndex: Int)
//    {
////        val favorite = FavoriteEntity(phraseId = categoryId, phraseIndex = phraseIndex)
////        mFavoriteDao.insertFavorite(favorite)
//    }
//
//    fun deleteFavorite(categoryId: Int, phraseIndex: Int)
//    {
////        val favorite = FavoriteEntity(categoryId = categoryId, phraseIndex = phraseIndex)
////        mFavoriteDao.deleteFavorite(favorite)
//    }
}