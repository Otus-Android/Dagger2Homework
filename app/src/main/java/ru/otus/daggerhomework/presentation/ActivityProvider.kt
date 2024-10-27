package ru.otus.daggerhomework.presentation

import androidx.fragment.app.Fragment
import ru.otus.daggerhomework.di.main.MainActivityComponent

interface ActivityProvider {
    val mainActivityComponent: MainActivityComponent
}

fun Fragment.provider() = requireActivity() as ActivityProvider