package ru.otus.daggerhomework

sealed class Result {
    data class Success(val color : Int) : Result()
}