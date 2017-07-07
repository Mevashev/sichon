package com.example.hen.sichon.data

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.example.hen.sichon.data.daos.FavoriteDao
import com.example.hen.sichon.data.entities.FavoriteEntity

@Database(entities = arrayOf(FavoriteEntity::class), version = 6)
abstract class FavoriteDatabase : RoomDatabase()
{
    abstract fun favoriteDao(): FavoriteDao
}