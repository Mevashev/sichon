package com.example.hen.sichon.enums

import android.support.annotation.ArrayRes
import android.support.annotation.DrawableRes
import com.example.hen.sichon.R

enum class Category(val categoryName: String, @DrawableRes val image: Int, @ArrayRes val categoryId: Int)
{
    SoftLanding("Soft Landing", R.drawable.landing, R.array.soft_landing),
    Conversation("Conversation", R.drawable.speech_bubble, R.array.conversation),
    Questions("Questions", R.drawable.question, R.array.questions),
    Numbers("Numbers", R.drawable.hand, R.array.numbers),
    Clock("Clock", R.drawable.clock, R.array.clock),
    Colors("Colors", R.drawable.palette, R.array.colors),
    Transportation("Transportation", R.drawable.school_bus, R.array.transportation)
}