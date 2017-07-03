package com.example.hen.sichon.database

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity
data class Favorite(@PrimaryKey val mId: Int, @ColumnInfo(name = "favorite_phrase") val phrase: String)
