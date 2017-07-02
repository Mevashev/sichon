package com.example.hen.sichon.managers

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences

object PersistenceManager
{
    private val PREF_TRANSLATE_TO_LANGUAGE = "pref.TRANSLATE_TO_LANGUAGE"
    private val PREF_TRANSLATE_FROM_LANGUAGE = "pref.TRANSLATE_FROM_LANGUAGE"

    private var mSharedPreferences: SharedPreferences? = null
        get()
        {
            return field ?: throw IllegalStateException("PersistenceManager has not been initialized.")
        }
        private set

    fun init(context: Context)
    {
        mSharedPreferences = context.getSharedPreferences("user_preferences", Context.MODE_PRIVATE)
    }

    private fun setString(key: String, value: String?)
    {
        putValue(key, value)
    }

   private fun getString(key: String): String?
    {
        if (mSharedPreferences?.contains(key) ?: false)
        {
            return mSharedPreferences?.getString(key, "")
        }
        return null
    }

    @SuppressLint("ApplySharedPref")
    private fun putValue(key: String, value: String?)
    {
        mSharedPreferences?.edit()?.putString(key, value)?.commit()
    }

    fun saveTranslteToLanguage(translateTo: String)
    {
        setString(PREF_TRANSLATE_TO_LANGUAGE, translateTo)
    }

    fun getTranslteToLanguage(): String?
    {
        return getString(PREF_TRANSLATE_TO_LANGUAGE)
    }

    fun saveTranslateFromLanguage(translateFrom: String)
    {
        setString(PREF_TRANSLATE_FROM_LANGUAGE, translateFrom)
    }

    fun getTranslateFromLanguage(): String?
    {
        return getString(PREF_TRANSLATE_FROM_LANGUAGE)
    }
}