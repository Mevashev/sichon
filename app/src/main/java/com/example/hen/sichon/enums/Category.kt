package com.example.hen.sichon.enums

import android.support.annotation.ArrayRes
import android.support.annotation.DrawableRes
import com.example.hen.sichon.R

enum class Category(val categoryName: String, @DrawableRes val image: Int, @ArrayRes val categoryId: Int)
{
    SOFT_LANDING("Soft Landing", R.drawable.landing, R.array.soft_landing),
    CONVERSATION("Conversation", R.drawable.speech_bubble, R.array.conversation),
    QUESTIONS("Questions", R.drawable.question, R.array.questions),
    NUMBERS("Numbers", R.drawable.hand, R.array.numbers),
    CLOCK("Clock", R.drawable.clock, R.array.clock),
    COLORS("Colors", R.drawable.palette, R.array.colors),
    TRANSPORTATION("Transportation", R.drawable.school_bus, R.array.transportation)
}