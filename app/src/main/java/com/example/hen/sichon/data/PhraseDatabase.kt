package com.example.hen.sichon.data

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.example.hen.sichon.data.daos.FavoriteDao
import com.example.hen.sichon.data.daos.PhraseDao
import com.example.hen.sichon.data.entities.FavoriteEntity
import com.example.hen.sichon.data.entities.PhraseEntity

@Database(entities = arrayOf(PhraseEntity::class), version = 6)
abstract class PhraseDatabase : RoomDatabase()
{
    abstract fun phraseDao(): PhraseDao
}