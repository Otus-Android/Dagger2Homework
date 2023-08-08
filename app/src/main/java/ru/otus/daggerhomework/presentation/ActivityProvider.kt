package ru.otus.daggerhomework.presentation

import androidx.fragment.app.Fragment
import dagger.Component
import ru.otus.daggerhomework.di.main.MainActivityComponent

/**
 * Поставщик элементов главного экрана
 */
interface ActivityProvider {

    /** `Dagger` [Component] главного экрана */
    val mainActivityComponent: MainActivityComponent
}

/** Получить [ActivityProvider] */
fun Fragment.provider() = requireActivity() as ActivityProvider