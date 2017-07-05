package com.example.hen.sichon.data.entities

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "favorites")
data class FavoriteEntity(
        @PrimaryKey
        @ColumnInfo(name = "phrase_id") var phraseId: Int?,
        @ColumnInfo(name = "is_favorite") var isFavorite: Boolean?)
{
        constructor(): this(0,false)
}
