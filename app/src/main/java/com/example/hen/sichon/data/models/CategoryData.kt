package com.example.hen.sichon.data.models

import com.google.gson.annotations.SerializedName

class CategoryData(
        @SerializedName("categoryId")
        val id: String,

        @SerializedName("categoryPhrases")
        val phrases: Array<PhraseData>)