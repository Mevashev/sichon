package com.example.hen.sichon

fun String.getValue(): String
{
   return this.substringBefore("$")
}

fun String.getId(): Int
{
    return this.substringAfter("$").toInt()
}