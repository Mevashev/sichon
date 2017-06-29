package com.example.hen.sichon.enums

import java.util.*

enum class Language(val languageName: String, val locale: Locale)
{
    ENGLISH("English", Locale.US),
    HEBREW("עברית", Locale("iw", "IL")),
    RUSSIAN("Русский", Locale("ru"))
}