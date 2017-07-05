package com.example.hen.sichon.data.daos

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import com.example.hen.sichon.data.entities.PhraseEntity

@Dao
interface PhraseDao
{
    @Insert
    fun insertPhrase(phrase: PhraseEntity)
}