package com.example.hen.sichon.database

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity

@Entity(primaryKeys = arrayOf("category_id","phrase_index"))
data class Favorite(
        @ColumnInfo(name = "category_id") var categoryId: Int,
        @ColumnInfo(name = "phrase_index") var phraseIndex: Int)
