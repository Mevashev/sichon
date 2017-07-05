package com.example.hen.sichon.enums

import android.support.annotation.DrawableRes
import android.support.annotation.StringRes
import com.example.hen.sichon.R

enum class Category(@StringRes val categoryName: Int, @DrawableRes val image: Int)
{
    SOFT_LANDING(R.string.category_soft_landing, R.drawable.landing),
    CONVERSATION(R.string.category_conversation, R.drawable.speech_bubble),
    QUESTIONS(R.string.category_questions, R.drawable.question),
    CLOCK(R.string.category_clock, R.drawable.clock),
    COLORS(R.string.category_colors, R.drawable.palette),
    NUMBERS(R.string.category_numbers, R.drawable.hand),
    TRANSPORTATION_BUSES(R.string.category_transportation_buses, R.drawable.school_bus),
    TRANSPORTATION_FLIGHTS(R.string.category_transportation_flights, R.drawable.airplane),
    TRANSPORTATION_TAXIS(R.string.category_transportation_taxis, R.drawable.taxi),
    TRANSPORTATION_CAR_RENTAL(R.string.category_transportation_car_rental, R.drawable.rent_a_car),
    FORECAST(R.string.category_forecast, R.drawable.cloudy),
    TRIPS_AND_BACKPACKING(R.string.category_trips_and_backpacking, R.drawable.hiker),
    LODGING(R.string.category_lodging, R.drawable.hotel),
    MONEY_AND_ARRANGEMENTS(R.string.category_money_and_arrangements, R.drawable.wallet),
    HEALTH(R.string.category_health, R.drawable.first_aid_kit),
    FOOD_AND_ENTERTAINMENT(R.string.category_food_and_entertainment, R.drawable.cutlery),
    EMERGENCY_SITUATIONS_AND_PROBLEMS(R.string.category_emergency_situations_and_problems, R.drawable.warning),
    SHOPPING(R.string.category_shopping, R.drawable.price_tag),
    COMMUNICATION(R.string.category_communication, R.drawable.hand_gesture),
    CLOTHES_AND_LAUNDRY(R.string.category_clothes_and_laundry, R.drawable.iron)
}