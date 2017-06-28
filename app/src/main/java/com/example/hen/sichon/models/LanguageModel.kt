package com.example.hen.sichon.models

/**
 * Created by slava-android on 6/28/2017.
 * Falcore Ltd.
 */
data class LanguageModel(val image: Int, val language: Language) {


    enum class Language private constructor(val parameterName: String) {
        ENGLISH("English"),
        HEBREW("Hebrew"),
        RUSSIAN("Russian")
    }

}