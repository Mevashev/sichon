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
    CLOCK(R.string.category_clock, R.drawable.clock, R.array.clock),
    COLORS(R.string.category_colors, R.drawable.palette, R.array.colors),
    NUMBERS(R.string.category_numbers, R.drawable.hand, R.array.numbers),
    TRANSPORTATION_BUSES(R.string.category_transportation_buses, R.drawable.school_bus, R.array.transportation_bus),
    TRANSPORTATION_FLIGHTS(R.string.category_transportation_flights, R.drawable.airplane, R.array.transportation_bus),
    TRANSPORTATION_TAXIS(R.string.category_transportation_taxis, R.drawable.taxi, R.array.transportation_bus),
    TRANSPORTATION_CAR_RENTAL(R.string.category_transportation_car_rental, R.drawable.rent_a_car, R.array.transportation_bus),
    FORECAST(R.string.category_forecast, R.drawable.cloudy, R.array.transportation_bus),
    TRIPS_AND_BACKPACKING(R.string.category_trips_and_backpacking, R.drawable.hiker, R.array.transportation_bus),
    LODGING(R.string.category_lodging, R.drawable.hotel, R.array.transportation_bus),
    MONEY_AND_ARRANGEMENTS(R.string.category_money_and_arrangements, R.drawable.wallet, R.array.transportation_bus),
    HEALTH(R.string.category_health, R.drawable.first_aid_kit, R.array.transportation_bus),
    FOOD_AND_ENTERTAINMENT(R.string.category_food_and_entertainment, R.drawable.cutlery, R.array.transportation_bus),
    EMERGENCY_SITUATIONS_AND_PROBLEMS(R.string.category_emergency_situations_and_problems, R.drawable.warning, R.array.transportation_bus),
    SHOPPING(R.string.category_shopping, R.drawable.price_tag, R.array.transportation_bus),
    COMMUNICATION(R.string.category_communication, R.drawable.hand_gesture, R.array.transportation_bus),
    CLOTHES_AND_LAUNDRY(R.string.category_clothes_and_laundry, R.drawable.iron, R.array.transportation_bus)
}