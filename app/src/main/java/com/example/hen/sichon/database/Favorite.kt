package com.example.hen.sichon.database

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity
data class Favorite(@PrimaryKey var mId: Int? = null, @ColumnInfo(name = "favorite_phrase") var phrase: String)
{
    constructor() : this(null, "")
}
