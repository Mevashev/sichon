package com.example.hen.sichon.models

data class PhraseModel(
        val translateFrom: String,
        val translateTo: String,
        var isFavorite: Boolean = false)
