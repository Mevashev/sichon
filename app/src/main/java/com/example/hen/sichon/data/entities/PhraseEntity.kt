package com.example.hen.sichon.data.entities

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "phrases")
data class PhraseEntity(
        @PrimaryKey
        @ColumnInfo(name = "phrase_id") var phraseId: Int?,
        @ColumnInfo(name = "category") var category: String?,
        @ColumnInfo(name = "english") var english: String?,
        @ColumnInfo(name = "hebrew") var hebrew: String?,
        @ColumnInfo(name = "russian") var russian: String?)
{
        constructor(): this(0,"","","","")
}