package com.example.hen.sichon.data.models

import com.google.gson.annotations.SerializedName

class PhraseData(
        @SerializedName("id")
        val id: Int,

        @SerializedName("english")
        val english: String,

        @SerializedName("hebrew")
        val hebrew: String,

        @SerializedName("russian")
        val russian: String)
