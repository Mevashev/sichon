package com.example.hen.sichon.enums

import android.support.annotation.ArrayRes
import android.support.annotation.DrawableRes
import android.support.annotation.StringRes
import com.example.hen.sichon.R

enum class Category(@StringRes val categoryName: Int, @DrawableRes val image: Int, @ArrayRes val categoryId: Int)
{
    SOFT_LANDING(R.string.category_soft_landing, R.drawable.landing, R.array.soft_landing),
    CONVERSATION(R.string.category_conversation, R.drawable.speech_bubble, R.array.conversation),
    QUESTIONS(R.string.category_questions, R.drawable.question, R.array.questions),
    NUMBERS(R.string.category_numbers, R.drawable.hand, R.array.numbers),
    CLOCK(R.string.category_clock, R.drawable.clock, R.array.clock),
    COLORS(R.string.category_colors, R.drawable.palette, R.array.colors),
    TRANSPORTATION(R.string.category_transportation, R.drawable.school_bus, R.array.transportation)
}