package com.example.hen.sichon.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase

@Database(entities = arrayOf(Favorite::class), version = 1)
abstract class AppDatabase: RoomDatabase()
{

    abstract fun favoriteDao(): FavoriteDao
}