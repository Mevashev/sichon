package com.example.hen.sichon.enums

import java.util.*

enum class Language(val languageName: String, val locale: Locale) {
    ENGLISH("English", Locale.US),
    HEBREW("עברית", Locale("iw", "IL")),
    RUSSIAN("Русский", Locale("ru"));

    companion object {
        fun getLanguageFromString(lang: String?): Language {
            when (lang) {
                ENGLISH.toString() -> return ENGLISH
                HEBREW.toString() -> return HEBREW
                RUSSIAN.toString() -> return RUSSIAN
                else -> return ENGLISH

            }
        }
    }
}