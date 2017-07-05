package com.example.hen.sichon.data.models

import com.google.gson.annotations.SerializedName

class Data
{
    @SerializedName("categories")
    lateinit var categories: Array<CategoryData>
}